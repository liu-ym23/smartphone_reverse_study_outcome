package com.stepos.alphame.screen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.manager.ActionManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ScreenEventDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {4};
    private static final long SCREEN_EVENT_REGISTER_DELAY = 30000;
    private ScreenBroadcastReceiver mScreenReceiver;

    public static class InitCompleteHandler extends Handler {
        private final WeakReference<ScreenEventDataSource> ref;

        public InitCompleteHandler(ScreenEventDataSource screenEventDataSource) {
            this.ref = new WeakReference<>(screenEventDataSource);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ScreenEventDataSource screenEventDataSource = this.ref.get();
            if (screenEventDataSource != null) {
                screenEventDataSource.registerScreenReceiver();
            }
        }
    }

    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        public /* synthetic */ ScreenBroadcastReceiver(ScreenEventDataSource screenEventDataSource, int i4) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || action.length() <= 0) {
                Log.e("AlphaMe", "receive a null intent");
                return;
            }
            if (action.equals("android.intent.action.SCREEN_ON")) {
                ScreenEventDataItem screenEventDataItem = (ScreenEventDataItem) ScreenEventDataSource.this.itemCache().pop();
                screenEventDataItem.fill(1);
                ScreenEventDataSource.this.process(screenEventDataItem);
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                ScreenEventDataItem screenEventDataItem2 = (ScreenEventDataItem) ScreenEventDataSource.this.itemCache().pop();
                screenEventDataItem2.fill(0);
                ScreenEventDataSource.this.process(screenEventDataItem2);
            }
        }

        private ScreenBroadcastReceiver() {
        }
    }

    public ScreenEventDataSource(String str) {
        super(str);
        this.mScreenReceiver = new ScreenBroadcastReceiver(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerScreenReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(1000);
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        ApplicationImpl.getApplication().registerReceiver(this.mScreenReceiver, intentFilter);
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return new ScreenEventStorable();
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return ScreenEventDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    @Override // com.stepos.alphame.data.DataSource
    public int getThreshold() {
        return 1;
    }

    public void onInitComplete() {
        new InitCompleteHandler(this).sendEmptyMessage(0);
    }

    @Override // com.stepos.alphame.data.DataSource
    public void process(DataItem dataItem) {
        super.process(dataItem);
        synchronized (this.mSyncObject) {
            ActionManager.getInstance().broadcast("SCREEN_EVENT", Integer.valueOf(((ScreenEventDataItem) dataItem).getEvent()));
        }
    }
}
