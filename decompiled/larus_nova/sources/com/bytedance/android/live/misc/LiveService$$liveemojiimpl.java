package com.bytedance.android.live.misc;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.emoji.AwemeEmojiProxy;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livesdk.performance.LiveSdkInitHelper;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$liveemojiimpl {

    public class a implements mc1.a.InterfaceC6796a<IService> {
        public a() {
        }
    }

    public LiveService$$liveemojiimpl() {
    }

    public static void oldRegisterService() {
    }

    public static void innerRegisterService() {
        jc1.k.l(IAwemeEmojiProxy.class, new AwemeEmojiProxy());
    }

    public static void lazyRegisterService() {
        a r100 = new a();
        mc1.a r101 = mc1.a.c.f512867a;
        r101.getClass();
        mc1.a.b r102 = new mc1.a.b(r100);
        ((ConcurrentHashMap) r101.f512862a).put(new Class[]{IAwemeEmojiProxy.class}[0], r102);
    }

    public static void registerService() {
        if (LiveSdkInitHelper.isEnableServiceOpt() == false) goto L5;
        lazyRegisterService();
    L6:
        oldRegisterService();
        return;
    L5:
        innerRegisterService();
        goto L6
    }
}
