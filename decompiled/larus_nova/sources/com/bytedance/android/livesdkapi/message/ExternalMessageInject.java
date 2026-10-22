package com.bytedance.android.livesdkapi.message;

import am3.c;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.n;

/* JADX INFO: loaded from: classes12.dex */
public class ExternalMessageInject implements IExternalMessageInject {
    private static ExternalMessageInject mInstance;
    HashMap<String, Class<? extends t>> externalMessage;
    HashMap<Class, c> externalMessageDecoder;

    public static class InjectInfo {
        private final c customMessageDecoder;
        private final String messageMethod;
        private final Class<? extends t> messageType;

        public static /* synthetic */ String access$000(InjectInfo r100) {
            return r100.messageMethod;
        }

        public static /* synthetic */ Class access$100(InjectInfo r100) {
            return r100.messageType;
        }

        public static /* synthetic */ c access$200(InjectInfo r100) {
            return r100.customMessageDecoder;
        }

        public InjectInfo(String r100, Class<? extends t> r101) {
            this(r100, r101, null);
        }

        public InjectInfo(String r100, Class<? extends t> r101, c r102) {
            this.messageMethod = ExternalMessageInject.access$300(r100);
            this.messageType = r101;
            this.customMessageDecoder = r102;
        }
    }

    public static ExternalMessageInject getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(ExternalMessageInject.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new ExternalMessageInject();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExternalMessageInject.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private ExternalMessageInject() {
        this.externalMessage = new HashMap();
        this.externalMessageDecoder = new HashMap();
    }

    public static /* synthetic */ String access$300(String r100) {
        return externalMethodName(r100);
    }

    private static String externalMethodName(String r100) {
        if (r100.startsWith(MessageType.WEBCAST_OPEN) == true) goto L5;
        return r100;
    L5:
        return r100.replace(MessageType.WEBCAST_OPEN, MessageType.WEBCAST);
    }

    public c getDecoder(Class r100) {
        return this.externalMessageDecoder.get(r100);
    }

    public Class<? extends t> getMessageClass(String r100) {
        return this.externalMessage.get(r100);
    }

    public void inject(InjectInfo r100) {
        HashMap<String, Class<? extends t>> r101 = this.externalMessage;
        int r102 = n.f530976a;
        String r103 = InjectInfo.access$000(r100);
        Intrinsics.checkNotNullParameter(r103, "msgMethod");
        if (StringsKt.startsWith$default(r103, MessageType.WEBCAST_OPEN, false, 2, null) == false) goto L5;
        r103 = StringsKt.replace$default(r103, MessageType.WEBCAST_OPEN, MessageType.WEBCAST, false, 4, null);
    L5:
        r101.put(r103, InjectInfo.access$100(r100));
        c r104 = InjectInfo.access$200(r100);
        if (r104 == null) goto L9;
        this.externalMessageDecoder.put(InjectInfo.access$100(r100), r104);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalMessageInject
    public void injectAllMessageClz(Map<String, Class<? extends t>> r100) {
        Iterator<String> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        this.externalMessage.put(externalMethodName(r102), r100.get(r102));
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalMessageInject
    public void injectMessageDecoder(Map<Class, c> r100) {
        this.externalMessageDecoder.putAll(r100);
    }

    public void inject(List<InjectInfo> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<InjectInfo> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        inject(r101.next());
        goto L6
    }
}
