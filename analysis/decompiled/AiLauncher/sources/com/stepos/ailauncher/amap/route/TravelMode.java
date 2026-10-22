package com.stepos.ailauncher.amap.route;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/amap/route/TravelMode;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", Const.INTENT_KEY_APIKEY, "DRIVING", "WALKING", "RIDING", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TravelMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TravelMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TravelMode DRIVING = new TravelMode("DRIVING", 0);
    public static final TravelMode WALKING = new TravelMode("WALKING", 1);
    public static final TravelMode RIDING = new TravelMode("RIDING", 2);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/amap/route/TravelMode$a;", "", "<init>", "()V", "", "key", "Lcom/stepos/ailauncher/amap/route/TravelMode;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/amap/route/TravelMode;", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.amap.route.TravelMode$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        
            if (r0.equals("driving") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        
            if (r0.equals("cycling") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        
            if (r0.equals("walking") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        
            if (r0.equals("drive") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        
            if (r0.equals("walk") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        
            if (r0.equals(O5.c.DIDI) == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
        
            if (r0.equals("ride") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        
            if (r0.equals("foot") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
        
            if (r0.equals("bike") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
        
            if (r0.equals("驾车") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
        
            if (r0.equals("骑行") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
        
            if (r0.equals("步行") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009f, code lost:
        
            return com.stepos.ailauncher.amap.route.TravelMode.WALKING;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a7, code lost:
        
            if (r0.equals(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.DEFAULT_APP_NAME) == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b0, code lost:
        
            if (r0.equals("car") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b5, code lost:
        
            return com.stepos.ailauncher.amap.route.TravelMode.DRIVING;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00bc, code lost:
        
            if (r0.equals("bicycle") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c6, code lost:
        
            if (r0.equals("riding") == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00cd, code lost:
        
            return com.stepos.ailauncher.amap.route.TravelMode.RIDING;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.ailauncher.amap.route.TravelMode a(java.lang.String r1) {
            /*
                r0 = this;
                if (r1 == 0) goto Lce
                java.lang.CharSequence r0 = La.H.D1(r1)
                java.lang.String r0 = r0.toString()
                if (r0 == 0) goto Lce
                java.util.Locale r1 = java.util.Locale.ROOT
                java.lang.String r0 = r0.toLowerCase(r1)
                java.lang.String r1 = "toLowerCase(...)"
                kotlin.jvm.internal.p.h(r0, r1)
                if (r0 != 0) goto L1c
                goto Lce
            L1c:
                int r1 = r0.hashCode()
                switch(r1) {
                    case -931190859: goto Lbf;
                    case -117759745: goto Lb6;
                    case 98260: goto Laa;
                    case 817011: goto La0;
                    case 887175: goto L93;
                    case 1261531: goto L89;
                    case 1262760: goto L7f;
                    case 3023841: goto L76;
                    case 3148910: goto L6d;
                    case 3500280: goto L63;
                    case 3552798: goto L59;
                    case 3641801: goto L4e;
                    case 95852938: goto L44;
                    case 1118815609: goto L39;
                    case 1227428899: goto L2f;
                    case 1920367559: goto L25;
                    default: goto L23;
                }
            L23:
                goto Lc8
            L25:
                java.lang.String r1 = "driving"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lb3
                goto Lc8
            L2f:
                java.lang.String r1 = "cycling"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lcb
                goto Lc8
            L39:
                java.lang.String r1 = "walking"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L9d
                goto Lc8
            L44:
                java.lang.String r1 = "drive"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lb3
                goto Lc8
            L4e:
                java.lang.String r1 = "walk"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L9d
                goto Lc8
            L59:
                java.lang.String r1 = "taxi"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lb3
                goto Lc8
            L63:
                java.lang.String r1 = "ride"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lcb
                goto Lc8
            L6d:
                java.lang.String r1 = "foot"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L9d
                goto Lc8
            L76:
                java.lang.String r1 = "bike"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lcb
                goto Lc8
            L7f:
                java.lang.String r1 = "驾车"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lb3
                goto Lc8
            L89:
                java.lang.String r1 = "骑行"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lcb
                goto Lc8
            L93:
                java.lang.String r1 = "步行"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L9d
                goto Lc8
            L9d:
                com.stepos.ailauncher.amap.route.TravelMode r0 = com.stepos.ailauncher.amap.route.TravelMode.WALKING
                return r0
            La0:
                java.lang.String r1 = "打车"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lb3
                goto Lc8
            Laa:
                java.lang.String r1 = "car"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lb3
                goto Lc8
            Lb3:
                com.stepos.ailauncher.amap.route.TravelMode r0 = com.stepos.ailauncher.amap.route.TravelMode.DRIVING
                return r0
            Lb6:
                java.lang.String r1 = "bicycle"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lcb
                goto Lc8
            Lbf:
                java.lang.String r1 = "riding"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto Lcb
            Lc8:
                com.stepos.ailauncher.amap.route.TravelMode r0 = com.stepos.ailauncher.amap.route.TravelMode.DRIVING
                return r0
            Lcb:
                com.stepos.ailauncher.amap.route.TravelMode r0 = com.stepos.ailauncher.amap.route.TravelMode.RIDING
                return r0
            Lce:
                com.stepos.ailauncher.amap.route.TravelMode r0 = com.stepos.ailauncher.amap.route.TravelMode.DRIVING
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.amap.route.TravelMode.Companion.a(java.lang.String):com.stepos.ailauncher.amap.route.TravelMode");
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ TravelMode[] $values() {
        return new TravelMode[]{DRIVING, WALKING, RIDING};
    }

    static {
        TravelMode[] travelModeArr$values = $values();
        $VALUES = travelModeArr$values;
        $ENTRIES = kotlin.enums.a.a(travelModeArr$values);
        INSTANCE = new Companion(null);
    }

    private TravelMode(String str, int i10) {
    }

    public static InterfaceC4149a<TravelMode> getEntries() {
        return $ENTRIES;
    }

    public static TravelMode valueOf(String str) {
        return (TravelMode) Enum.valueOf(TravelMode.class, str);
    }

    public static TravelMode[] values() {
        return (TravelMode[]) $VALUES.clone();
    }
}
