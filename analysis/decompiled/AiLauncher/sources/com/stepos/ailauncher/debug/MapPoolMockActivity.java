package com.stepos.ailauncher.debug;

import N5.CardEnvelope;
import N5.n;
import N5.v;
import Y8.j;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.B;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.E;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u00014\u0018\u0000 72\u00020\u0001:\u000389:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/debug/MapPoolMockActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Landroid/widget/LinearLayout;", "n", "()Landroid/widget/LinearLayout;", "", "title", "Lcom/stepos/ailauncher/debug/MapPoolMockActivity$MountType;", "type", "k", "(Ljava/lang/String;Lcom/stepos/ailauncher/debug/MapPoolMockActivity$MountType;)Landroid/widget/LinearLayout;", "", "count", "p", "(I)V", "", "sameTask", "", "Lcom/stepos/ailauncher/debug/MapPoolMockActivity$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(IZ)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "v", "m", "(I)I", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Landroid/widget/TextView;", "statusView", "Landroid/widget/TextView;", "cardsHost", "Landroid/widget/LinearLayout;", "Landroid/widget/CheckBox;", "sameTaskCheck", "Landroid/widget/CheckBox;", "", "LN5/d;", "boundViews", "Ljava/util/List;", "mountType", "Lcom/stepos/ailauncher/debug/MapPoolMockActivity$MountType;", "com/stepos/ailauncher/debug/MapPoolMockActivity$d", "refreshPool", "Lcom/stepos/ailauncher/debug/MapPoolMockActivity$d;", "Companion", "MountType", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MapPoolMockActivity extends Activity {
    public static final String ACTION = "com.stepos.ailauncher.action.DEBUG_MAP_POOL_MOCK";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_COUNT = "count";
    public static final String EXTRA_TYPE = "type";
    private static final String TAG = "MapPoolMock";
    private LinearLayout cardsHost;
    private CheckBox sameTaskCheck;
    private TextView statusView;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final List<N5.d> boundViews = new ArrayList();
    private MountType mountType = MountType.POI;
    private final d refreshPool = new d();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/debug/MapPoolMockActivity$MountType;", "", "<init>", "(Ljava/lang/String;I)V", "POI", "ROUTE", "MIX", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MountType {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ MountType[] $VALUES;
        public static final MountType POI = new MountType("POI", 0);
        public static final MountType ROUTE = new MountType("ROUTE", 1);
        public static final MountType MIX = new MountType("MIX", 2);

        private static final /* synthetic */ MountType[] $values() {
            return new MountType[]{POI, ROUTE, MIX};
        }

        static {
            MountType[] mountTypeArr$values = $values();
            $VALUES = mountTypeArr$values;
            $ENTRIES = kotlin.enums.a.a(mountTypeArr$values);
        }

        private MountType(String str, int i10) {
        }

        public static InterfaceC4149a<MountType> getEntries() {
            return $ENTRIES;
        }

        public static MountType valueOf(String str) {
            return (MountType) Enum.valueOf(MountType.class, str);
        }

        public static MountType[] values() {
            return (MountType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/debug/MapPoolMockActivity$a;", "", "<init>", "()V", "", "raw", "Lcom/stepos/ailauncher/debug/MapPoolMockActivity$MountType;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/debug/MapPoolMockActivity$MountType;", "ACTION", "Ljava/lang/String;", "EXTRA_COUNT", "EXTRA_TYPE", "TAG", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.debug.MapPoolMockActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            if (r0.equals(O5.c.MAP_ROUTE) == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        
            if (r0.equals(M5.a.CARD_TYPE_ROUTE) == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            return com.stepos.ailauncher.debug.MapPoolMockActivity.MountType.ROUTE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        
            if (r0.equals("mixed") == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        
            if (r0.equals("mix") == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        
            return com.stepos.ailauncher.debug.MapPoolMockActivity.MountType.MIX;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.ailauncher.debug.MapPoolMockActivity.MountType b(java.lang.String r1) {
            /*
                r0 = this;
                if (r1 == 0) goto Lf
                java.util.Locale r0 = java.util.Locale.ROOT
                java.lang.String r0 = r1.toLowerCase(r0)
                java.lang.String r1 = "toLowerCase(...)"
                kotlin.jvm.internal.p.h(r0, r1)
                goto L10
            Lf:
                r0 = 0
            L10:
                if (r0 == 0) goto L45
                int r1 = r0.hashCode()
                switch(r1) {
                    case 108124: goto L39;
                    case 103910395: goto L30;
                    case 108704329: goto L23;
                    case 1254507942: goto L1a;
                    default: goto L19;
                }
            L19:
                goto L45
            L1a:
                java.lang.String r1 = "map_route"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L2d
                goto L45
            L23:
                java.lang.String r1 = "route"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L2d
                goto L45
            L2d:
                com.stepos.ailauncher.debug.MapPoolMockActivity$MountType r0 = com.stepos.ailauncher.debug.MapPoolMockActivity.MountType.ROUTE
                return r0
            L30:
                java.lang.String r1 = "mixed"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L42
                goto L45
            L39:
                java.lang.String r1 = "mix"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L42
                goto L45
            L42:
                com.stepos.ailauncher.debug.MapPoolMockActivity$MountType r0 = com.stepos.ailauncher.debug.MapPoolMockActivity.MountType.MIX
                return r0
            L45:
                com.stepos.ailauncher.debug.MapPoolMockActivity$MountType r0 = com.stepos.ailauncher.debug.MapPoolMockActivity.MountType.POI
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.debug.MapPoolMockActivity.Companion.b(java.lang.String):com.stepos.ailauncher.debug.MapPoolMockActivity$MountType");
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/debug/MapPoolMockActivity$b;", "", "", "kind", "toolCallId", "LN5/i;", "envelope", "LN5/v;", Const.JSON_KEY_PROVIDER, "<init>", "(Ljava/lang/String;Ljava/lang/String;LN5/i;LN5/v;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "LN5/i;", Const.INTENT_KEY_APIKEY, "()LN5/i;", "LN5/v;", "c", "()LN5/v;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.debug.MapPoolMockActivity$b, reason: from toString */
    public static final /* data */ class MountEntry {
        private final CardEnvelope envelope;
        private final String kind;
        private final v provider;
        private final String toolCallId;

        public MountEntry(String kind, String toolCallId, CardEnvelope envelope, v provider) {
            p.i(kind, "kind");
            p.i(toolCallId, "toolCallId");
            p.i(envelope, "envelope");
            p.i(provider, "provider");
            this.kind = kind;
            this.toolCallId = toolCallId;
            this.envelope = envelope;
            this.provider = provider;
        }

        /* renamed from: a, reason: from getter */
        public final CardEnvelope getEnvelope() {
            return this.envelope;
        }

        /* renamed from: b, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        /* renamed from: c, reason: from getter */
        public final v getProvider() {
            return this.provider;
        }

        /* renamed from: d, reason: from getter */
        public final String getToolCallId() {
            return this.toolCallId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MountEntry)) {
                return false;
            }
            MountEntry mountEntry = (MountEntry) other;
            return p.d(this.kind, mountEntry.kind) && p.d(this.toolCallId, mountEntry.toolCallId) && p.d(this.envelope, mountEntry.envelope) && p.d(this.provider, mountEntry.provider);
        }

        public int hashCode() {
            return (((((this.kind.hashCode() * 31) + this.toolCallId.hashCode()) * 31) + this.envelope.hashCode()) * 31) + this.provider.hashCode();
        }

        public String toString() {
            return "MountEntry(kind=" + this.kind + ", toolCallId=" + this.toolCallId + ", envelope=" + this.envelope + ", provider=" + this.provider + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MountType.values().length];
            try {
                iArr[MountType.POI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MountType.ROUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MountType.MIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/debug/MapPoolMockActivity$d", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MapPoolMockActivity.this.statusView == null) {
                return;
            }
            String strD = B.INSTANCE.d();
            TextView textView = MapPoolMockActivity.this.statusView;
            if (textView == null) {
                p.A("statusView");
                textView = null;
            }
            textView.setText("mode=" + MapPoolMockActivity.this.mountType + " cards=" + MapPoolMockActivity.this.boundViews.size() + " | " + strD);
            TextView textView2 = MapPoolMockActivity.this.statusView;
            if (textView2 == null) {
                p.A("statusView");
                textView2 = null;
            }
            C4148a.k(MapPoolMockActivity.TAG, textView2.getText().toString(), false, 4, null);
            MapPoolMockActivity.this.mainHandler.postDelayed(this, 800L);
        }
    }

    public static final void l(MapPoolMockActivity mapPoolMockActivity, MountType mountType, int i10, View view) {
        mapPoolMockActivity.mountType = mountType;
        mapPoolMockActivity.p(i10);
    }

    public static final void o(MapPoolMockActivity mapPoolMockActivity, MountType mountType, View view) {
        mapPoolMockActivity.mountType = mountType;
    }

    public static final void q(MapPoolMockActivity mapPoolMockActivity, View view) {
        mapPoolMockActivity.mountType = MountType.MIX;
        mapPoolMockActivity.p(4);
    }

    public static final void r(MapPoolMockActivity mapPoolMockActivity, View view) {
        mapPoolMockActivity.j();
    }

    public final List<MountEntry> i(int count, boolean sameTask) {
        List listM;
        int i10 = c.$EnumSwitchMapping$0[this.mountType.ordinal()];
        if (i10 == 1) {
            List<B.MockCard> listA = B.INSTANCE.a(count, sameTask);
            ArrayList arrayList = new ArrayList(C1174w.x(listA, 10));
            for (B.MockCard mockCard : listA) {
                arrayList.add(new MountEntry("poi", mockCard.getToolCallId(), mockCard.getEnvelope(), B.INSTANCE.f()));
            }
            return arrayList;
        }
        if (i10 == 2) {
            List<E.MockCard> listA2 = E.INSTANCE.a(count, sameTask);
            ArrayList arrayList2 = new ArrayList(C1174w.x(listA2, 10));
            for (E.MockCard mockCard2 : listA2) {
                arrayList2.add(new MountEntry(M5.a.CARD_TYPE_ROUTE, mockCard2.getToolCallId(), mockCard2.getEnvelope(), E.INSTANCE.c()));
            }
            return arrayList2;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        int i11 = (count + 1) / 2;
        int i12 = count / 2;
        List<B.MockCard> listA3 = B.INSTANCE.a(C5685n.f(i11, 1), sameTask);
        ArrayList arrayList3 = new ArrayList(C1174w.x(listA3, 10));
        for (B.MockCard mockCard3 : listA3) {
            arrayList3.add(new MountEntry("poi", mockCard3.getToolCallId(), mockCard3.getEnvelope(), B.INSTANCE.f()));
        }
        if (i12 > 0) {
            List<E.MockCard> listA4 = E.INSTANCE.a(i12, sameTask);
            listM = new ArrayList(C1174w.x(listA4, 10));
            for (E.MockCard mockCard4 : listA4) {
                listM.add(new MountEntry(M5.a.CARD_TYPE_ROUTE, mockCard4.getToolCallId(), mockCard4.getEnvelope(), E.INSTANCE.c()));
            }
        } else {
            listM = C1173v.m();
        }
        ArrayList arrayList4 = new ArrayList(arrayList3.size() + listM.size());
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= arrayList3.size() && i14 >= listM.size()) {
                return arrayList4;
            }
            if (i13 < arrayList3.size()) {
                arrayList4.add(arrayList3.get(i13));
                i13++;
            }
            if (i14 < listM.size()) {
                arrayList4.add(listM.get(i14));
                i14++;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        Iterator<T> it = this.boundViews.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            N5.d dVar = (N5.d) it.next();
            ViewParent parent = dVar.getParent();
            viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(dVar);
            }
            dVar.setVisibility(8);
        }
        this.boundViews.clear();
        LinearLayout linearLayout = this.cardsHost;
        if (linearLayout == null) {
            p.A("cardsHost");
        } else {
            viewGroup = linearLayout;
        }
        viewGroup.removeAllViews();
    }

    public final LinearLayout k(String title, final MountType type) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextColor(Color.parseColor("#80CBC4"));
        textView.setTextSize(13.0f);
        textView.setWidth(m(40));
        linearLayout.addView(textView);
        Iterator it = C1173v.p(1, 2, 3, 5).iterator();
        while (it.hasNext()) {
            final int iIntValue = ((Number) it.next()).intValue();
            Button button = new Button(this);
            button.setText(iIntValue + "张");
            button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.debug.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapPoolMockActivity.l(this.f27091a, type, iIntValue, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.setMarginEnd(m(4));
            t tVar = t.f7040a;
            linearLayout.addView(button, layoutParams);
        }
        return linearLayout;
    }

    public final int m(int v10) {
        return (int) TypedValue.applyDimension(1, v10, getResources().getDisplayMetrics());
    }

    public final LinearLayout n() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        for (Pair pair : C1173v.p(j.a("当前→多店", MountType.POI), j.a("当前→路线", MountType.ROUTE), j.a("当前→混挂", MountType.MIX))) {
            String str = (String) pair.a();
            final MountType mountType = (MountType) pair.b();
            Button button = new Button(this);
            button.setText(str);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.debug.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapPoolMockActivity.o(this.f27089a, mountType, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.setMarginEnd(m(4));
            t tVar = t.f7040a;
            linearLayout.addView(button, layoutParams);
        }
        return linearLayout;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Companion companion = INSTANCE;
        Intent intent = getIntent();
        LinearLayout linearLayout = null;
        this.mountType = companion.b(intent != null ? intent.getStringExtra("type") : null);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(Color.parseColor("#121212"));
        linearLayout2.setPadding(m(12), m(12), m(12), m(12));
        TextView textView = new TextView(this);
        textView.setTextColor(-1);
        textView.setTextSize(13.0f);
        textView.setText("ready");
        this.statusView = textView;
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setTextColor(Color.parseColor("#B0BEC5"));
        textView2.setTextSize(12.0f);
        textView2.setText("池 cap=2。多店=map_poi_list，路线=map_route，混挂=各一半。上下滑观察离屏 YIELD / 回屏 reclaim。");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m(6);
        layoutParams.bottomMargin = m(8);
        t tVar = t.f7040a;
        linearLayout2.addView(textView2, layoutParams);
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText("同 taskId / 不同 toolCallId");
        checkBox.setTextColor(-1);
        checkBox.setChecked(false);
        this.sameTaskCheck = checkBox;
        linearLayout2.addView(checkBox);
        linearLayout2.addView(n());
        linearLayout2.addView(k("多店", MountType.POI));
        linearLayout2.addView(k("路线", MountType.ROUTE));
        Button button = new Button(this);
        button.setText("混挂 2多店+2路线");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapPoolMockActivity.q(this.f27087a, view);
            }
        });
        linearLayout2.addView(button);
        Button button2 = new Button(this);
        button2.setText("清空");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapPoolMockActivity.r(this.f27088a, view);
            }
        });
        linearLayout2.addView(button2);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        this.cardsHost = linearLayout3;
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayout4 = this.cardsHost;
        if (linearLayout4 == null) {
            p.A("cardsHost");
        } else {
            linearLayout = linearLayout4;
        }
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        layoutParams2.topMargin = m(8);
        linearLayout2.addView(scrollView, layoutParams2);
        setContentView(linearLayout2);
        Intent intent2 = getIntent();
        p(intent2 != null ? C5685n.n(intent2.getIntExtra("count", 3), 1, 8) : 3);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mainHandler.removeCallbacks(this.refreshPool);
        j();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        this.mainHandler.removeCallbacks(this.refreshPool);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mainHandler.removeCallbacks(this.refreshPool);
        this.mainHandler.post(this.refreshPool);
    }

    public final void p(int count) {
        j();
        CheckBox checkBox = this.sameTaskCheck;
        if (checkBox == null) {
            p.A("sameTaskCheck");
            checkBox = null;
        }
        boolean zIsChecked = checkBox.isChecked();
        List<MountEntry> listI = i(count, zIsChecked);
        MountType mountType = this.mountType;
        List<MountEntry> list = listI;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MountEntry) it.next()).getKind());
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((MountEntry) it2.next()).getEnvelope().getTaskId());
        }
        C4148a.k(TAG, "mount type=" + mountType + " count=" + count + " sameTaskId=" + zIsChecked + " kinds=" + arrayList + " taskIds=" + arrayList2, false, 4, null);
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            MountEntry mountEntry = (MountEntry) obj;
            TextView textView = new TextView(this);
            textView.setTextColor(Color.parseColor("#80CBC4"));
            textView.setTextSize(12.0f);
            textView.setText(Const.STR_MART_WELL + i11 + " [" + mountEntry.getKind() + "] tool=" + mountEntry.getToolCallId() + " task=" + mountEntry.getEnvelope().getTaskId());
            LinearLayout linearLayout = this.cardsHost;
            if (linearLayout == null) {
                p.A("cardsHost");
                linearLayout = null;
            }
            linearLayout.addView(textView);
            n nVarB = mountEntry.getProvider().b(mountEntry.getEnvelope());
            N5.d dVarA = mountEntry.getProvider().a(this);
            dVarA.h(mountEntry.getEnvelope(), nVarB);
            LinearLayout linearLayout2 = this.cardsHost;
            if (linearLayout2 == null) {
                p.A("cardsHost");
                linearLayout2 = null;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = m(16);
            t tVar = t.f7040a;
            linearLayout2.addView(dVarA, layoutParams);
            this.boundViews.add(dVarA);
            i10 = i11;
        }
        Toast.makeText(this, "已挂 " + listI.size() + " 张 · " + this.mountType + " · sameTask=" + zIsChecked, 0).show();
        this.mainHandler.post(this.refreshPool);
    }
}
