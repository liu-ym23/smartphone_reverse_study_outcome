package com.zyql.ai.selector.broadcast;

import Z0.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class BroadcastManager {
    private static final String TAG = "BroadcastManager";
    private String action;
    private Intent intent;
    private a localBroadcastManager;

    private void createIntent() {
        if (this.intent == null) {
            Log.d(TAG, "intent is not created");
        }
        if (this.intent == null) {
            if (!TextUtils.isEmpty(this.action)) {
                this.intent = new Intent(this.action);
            }
            Log.d(TAG, "intent created with action");
        }
    }

    public static BroadcastManager getInstance(Context context) {
        BroadcastManager broadcastManager = new BroadcastManager();
        broadcastManager.localBroadcastManager = a.b(context.getApplicationContext());
        return broadcastManager;
    }

    public BroadcastManager action(String str) {
        this.action = str;
        return this;
    }

    public void broadcast() {
        String str;
        createIntent();
        Intent intent = this.intent;
        if (intent == null || (str = this.action) == null) {
            return;
        }
        intent.setAction(str);
        a aVar = this.localBroadcastManager;
        if (aVar != null) {
            aVar.d(this.intent);
        }
    }

    public BroadcastManager extras(Bundle bundle) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtras(bundle);
        return this;
    }

    public BroadcastManager intent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public BroadcastManager put(String str, ArrayList<? extends Parcelable> arrayList) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, arrayList);
        return this;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, List<String> list) {
        if (broadcastReceiver == null || list == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                intentFilter.addAction(it.next());
            }
        }
        a aVar = this.localBroadcastManager;
        if (aVar != null) {
            aVar.c(broadcastReceiver, intentFilter);
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            this.localBroadcastManager.e(broadcastReceiver);
        } catch (Exception unused) {
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver, String... strArr) {
        unregisterReceiver(broadcastReceiver);
    }

    public BroadcastManager put(String str, Parcelable[] parcelableArr) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, parcelableArr);
        return this;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        registerReceiver(broadcastReceiver, Arrays.asList(strArr));
    }

    public BroadcastManager put(String str, Parcelable parcelable) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, parcelable);
        return this;
    }

    public BroadcastManager put(String str, float f10) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, f10);
        return this;
    }

    public BroadcastManager put(String str, double d10) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, d10);
        return this;
    }

    public BroadcastManager put(String str, long j10) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, j10);
        return this;
    }

    public BroadcastManager put(String str, boolean z10) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, z10);
        return this;
    }

    public BroadcastManager put(String str, int i10) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, i10);
        return this;
    }

    public BroadcastManager put(String str, String str2) {
        createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, str2);
        return this;
    }
}
