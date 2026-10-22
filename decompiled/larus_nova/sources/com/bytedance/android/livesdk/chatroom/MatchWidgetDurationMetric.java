package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class MatchWidgetDurationMetric {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, List<a>> f105084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, Long> f105085b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/MatchWidgetDurationMetric$Type;", "", "", "widgetName", "Ljava/lang/String;", "getWidgetName", "()Ljava/lang/String;", "TAB", "COMMENT_INPUT", "TOOLBAR", "TITLE_BAR", "ANCHOR_INFO", "MORE_ANCHOR", "EPISODE_INTERACTIVE", "PUBLIC_SCREEN", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ANCHOR_INFO = null;
        public static final Type COMMENT_INPUT = null;
        public static final Type EPISODE_INTERACTIVE = null;
        public static final Type MORE_ANCHOR = null;
        public static final Type PUBLIC_SCREEN = null;
        public static final Type TAB = null;
        public static final Type TITLE_BAR = null;
        public static final Type TOOLBAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f105086a = null;
        private final String widgetName;

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f105086a.clone();
        }

        static {
            Type r100 = new Type("TAB", 0, "tab");
            TAB = r100;
            Type r101 = new Type("COMMENT_INPUT", 1, "comment_input");
            COMMENT_INPUT = r101;
            Type r102 = new Type("TOOLBAR", 2, NewBroadcastMonitor.STAGE.TOOLBAR);
            TOOLBAR = r102;
            Type r103 = new Type("TITLE_BAR", 3, "title_bar");
            TITLE_BAR = r103;
            Type r104 = new Type("ANCHOR_INFO", 4, "anchor_info");
            ANCHOR_INFO = r104;
            Type r105 = new Type("MORE_ANCHOR", 5, "more_anchor");
            MORE_ANCHOR = r105;
            Type r106 = new Type("EPISODE_INTERACTIVE", 6, "episode_interactive");
            EPISODE_INTERACTIVE = r106;
            Type r107 = new Type("PUBLIC_SCREEN", 7, "public_screen");
            PUBLIC_SCREEN = r107;
            f105086a = new Type[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public final String getWidgetName() {
            return this.widgetName;
        }

        public Type(String r100, int r101, String r102) {
            super(r100, r101);
            this.widgetName = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f105087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f105088b;

        public final Type getType() {
            return this.f105088b;
        }

        public a(Type r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f105088b = r100;
        }
    }

    static {
        f105084a = new LinkedHashMap();
        f105085b = new LinkedHashMap();
    }

    public static void a(long r100, Type r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (f105085b.containsKey(Long.valueOf(r100)) == true) goto L5;
        return;
    L5:
        long r102 = System.currentTimeMillis();
        a r103 = b(r100, r101);
        if (r103.f105087a == null) goto L8;
        return;
    L8:
        r103.f105087a = Long.valueOf(r102);
    }

    public static a b(long r100, Type r101) {
        Map<Long, List<a>> r102 = f105084a;
        if (r102.containsKey(Long.valueOf(r100)) == false) goto L5;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        Object r104 = r103.get(Long.valueOf(r100));
        Intrinsics.checkNotNull(r104);
        List<a> r105 = (List) r104;
    L6:
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (((a) r107).getType() != r101) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L8;
    L16:
        a r109 = (a) r107;
        if (r109 != null) goto L25;
        a r110 = new a(r101);
        r105.add(r110);
        return r110;
    L25:
        return r109;
    L12:
        r108 = false;
        goto L13
    L15:
        r107 = null;
        goto L16
    L5:
        ArrayList r111 = new ArrayList();
        r102.put(Long.valueOf(r100), r111);
        r105 = r111;
        goto L6
    }
}
