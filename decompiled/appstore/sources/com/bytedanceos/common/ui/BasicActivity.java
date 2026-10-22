package com.bytedanceos.common.ui;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.networkv2.subscriber.ISubscriberManager;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicActivity extends FragmentActivity implements ISubscriberManager {
    private ArrayList<NSubscriber> mNSubscriberList;

    public BasicActivity() {
    }

    @Override // com.bytedanceos.common.networkv2.subscriber.ISubscriberManager
    public NSubscriber addNSubscriber(NSubscriber r10) {
        ArrayList<NSubscriber> r11 = this.mNSubscriberList;
        if (r11 == null) goto L5;
        r11.add(r10);
    L5:
        return r10;
    }

    public String getSourcePage() {
        return AdReportParam.ClickPosType.SKIP;
    }

    public String getSourcePageName() {
        return "";
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (userEventBus() == false) goto L5;
        EventBus.getDefault().register(this);
    L5:
        this.mNSubscriberList = new ArrayList();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (userEventBus() == false) goto L5;
        EventBus.getDefault().unregister(this);
    L5:
        ArrayList<NSubscriber> r10 = this.mNSubscriberList;
        if (r10 == null) goto L14;
        Iterator<NSubscriber> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        NSubscriber r12 = r11.next();
        if (r12 == null) goto L9;
        r12.unsubscribe();
        goto L9
    L13:
        this.mNSubscriberList.clear();
    L14:
        com.bytedanceos.common.toolbox.glide.b.a(this);
    }

    public boolean userEventBus() {
        return false;
    }
}
