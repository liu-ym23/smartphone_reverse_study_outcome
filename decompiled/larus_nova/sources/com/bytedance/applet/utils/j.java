package com.bytedance.applet.utils;

import androidx.collection.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, String> f192292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, String> f192293b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f192294c = null;

    public static final class a implements nf9.b {
        public a() {
        }

        @Override // nf9.b
        public final void b(String r100, MessageListState r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "msgList");
        }

        @Override // nf9.b
        public final void c(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void d(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void e(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void f(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "oldMsgList");
            Intrinsics.checkNotNullParameter(r102, "newMsgList");
        }

        @Override // nf9.b
        public final void a(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            LruCache<String, String> r102 = j.f192293b;
            String r103 = r101.getMessageId();
            String r104 = "";
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r102.put(r100, r103);
            LruCache<String, String> r105 = j.f192292a;
            String r106 = r101.getMessageId();
            if (r106 == null) goto L9;
            r104 = r106;
        L9:
            r105.put(r104, r100);
        }
    }

    static {
        f192292a = new LruCache(20);
        f192293b = new LruCache(20);
        f192294c = new a();
    }
}
