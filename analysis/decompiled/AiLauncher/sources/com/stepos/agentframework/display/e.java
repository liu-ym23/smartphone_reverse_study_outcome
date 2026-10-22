package com.stepos.agentframework.display;

import Y8.t;
import Z8.F;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003CDEB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010\u001fJ\u001f\u0010!\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\u00020\b*\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\u00020\u0011*\u00020#2\u0006\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00109\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010=\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/stepos/agentframework/display/e;", "", "<init>", "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lcom/stepos/agentframework/display/OverlayRefreshPriority;", "priority", "", "rateHz", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "e", "(Landroid/view/View;Lcom/stepos/agentframework/display/OverlayRefreshPriority;F)Ljava/lang/AutoCloseable;", Parameters.ROOT, "", "id", "LY8/t;", "p", "(Landroid/view/View;I)V", "Lcom/stepos/agentframework/display/e$d;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;Landroid/view/View;Lcom/stepos/agentframework/display/e$d;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;Lcom/stepos/agentframework/display/e$d;)V", "target", "targetMax", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;Lcom/stepos/agentframework/display/e$d;FF)V", "f", "(Lcom/stepos/agentframework/display/e$d;FF)V", "m", "q", "(Landroid/view/View;F)V", "Landroid/view/WindowManager$LayoutParams;", "o", "(Landroid/view/WindowManager$LayoutParams;)F", UxipConstants.f30680s, "t", "(Landroid/view/WindowManager$LayoutParams;F)V", "", "TAG", "Ljava/lang/String;", "lock", "Ljava/lang/Object;", "Ljava/util/WeakHashMap;", "windows", "Ljava/util/WeakHashMap;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextId", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/lang/reflect/Method;", "requestedFrameRateMethod$delegate", "LY8/h;", "l", "()Ljava/lang/reflect/Method;", "requestedFrameRateMethod", "requestedFrameRateDefault$delegate", "k", "()Ljava/lang/Float;", "requestedFrameRateDefault", "Ljava/lang/reflect/Field;", "preferredMaxField$delegate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/reflect/Field;", "preferredMaxField", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    private static final String TAG = "OverlayRefreshRate";
    public static final e INSTANCE = new e();
    private static final Object lock = new Object();
    private static final WeakHashMap<View, d> windows = new WeakHashMap<>();
    private static final AtomicInteger nextId = new AtomicInteger();

    /* renamed from: requestedFrameRateMethod$delegate, reason: from kotlin metadata */
    private static final Y8.h requestedFrameRateMethod = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.display.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return e.s();
        }
    });

    /* renamed from: requestedFrameRateDefault$delegate, reason: from kotlin metadata */
    private static final Y8.h requestedFrameRateDefault = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.display.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return e.r();
        }
    });

    /* renamed from: preferredMaxField$delegate, reason: from kotlin metadata */
    private static final Y8.h preferredMaxField = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.display.d
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return e.n();
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/display/e$a;", "", "", "rank", "", "rateHz", "<init>", "(IF)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "F", Const.INTENT_KEY_PKGNAME, "()F", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.display.e$a, reason: from toString */
    public static final /* data */ class Lease {
        private final int rank;
        private final float rateHz;

        public Lease(int i10, float f10) {
            this.rank = i10;
            this.rateHz = f10;
        }

        /* renamed from: a, reason: from getter */
        public final int getRank() {
            return this.rank;
        }

        /* renamed from: b, reason: from getter */
        public final float getRateHz() {
            return this.rateHz;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Lease)) {
                return false;
            }
            Lease lease = (Lease) other;
            return this.rank == lease.rank && Float.compare(this.rateHz, lease.rateHz) == 0;
        }

        public int hashCode() {
            return (Integer.hashCode(this.rank) * 31) + Float.hashCode(this.rateHz);
        }

        public String toString() {
            return "Lease(rank=" + this.rank + ", rateHz=" + this.rateHz + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/display/e$b;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroid/view/View;", Parameters.ROOT, "", "id", "<init>", "(Landroid/view/View;I)V", "LY8/t;", "close", "()V", "I", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "rootRef", "Ljava/lang/ref/WeakReference;", "", AlipayXuiIsland.REASON_CLOSED, "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AutoCloseable {
        private volatile boolean closed;
        private final int id;
        private final WeakReference<View> rootRef;

        public b(View root, int i10) {
            p.i(root, "root");
            this.id = i10;
            this.rootRef = new WeakReference<>(root);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            View view = this.rootRef.get();
            if (view == null) {
                return;
            }
            e.INSTANCE.p(view, this.id);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayWindowHost.values().length];
            try {
                iArr[DisplayWindowHost.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayWindowHost.OVERLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayWindowHost.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R3\u00102\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b00j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b`18\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/stepos/agentframework/display/e$d;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/agentframework/display/e$a;", "q", "()Lcom/stepos/agentframework/display/e$a;", "originalRate", "Ljava/lang/Float;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Float;", "p", "(Ljava/lang/Float;)V", "originalMax", "getOriginalMax", "o", "appliedRate", "c", "l", "appliedMax", Const.INTENT_KEY_PKGNAME, "k", "Lcom/stepos/agentframework/display/DisplayWindowHost;", "host", "Lcom/stepos/agentframework/display/DisplayWindowHost;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/display/DisplayWindowHost;", "m", "(Lcom/stepos/agentframework/display/DisplayWindowHost;)V", "", "lpType", "I", "f", "()I", "n", "(I)V", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/ref/WeakReference;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "leases", "Ljava/util/LinkedHashMap;", "e", "()Ljava/util/LinkedHashMap;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d {
        private WeakReference<Activity> activityRef;
        private Float appliedMax;
        private Float appliedRate;
        private Float originalMax;
        private Float originalRate;
        private DisplayWindowHost host = DisplayWindowHost.NONE;
        private int lpType = -1;
        private final LinkedHashMap<Integer, Lease> leases = new LinkedHashMap<>();

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d(Integer.valueOf(((Lease) t10).getRank()), Integer.valueOf(((Lease) t11).getRank()));
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class b<T> implements Comparator {
            final /* synthetic */ Comparator $this_thenBy;

            public b(Comparator comparator) {
                this.$this_thenBy = comparator;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int iCompare = this.$this_thenBy.compare(t10, t11);
                return iCompare != 0 ? iCompare : b9.b.d(Float.valueOf(((Lease) t10).getRateHz()), Float.valueOf(((Lease) t11).getRateHz()));
            }
        }

        public final WeakReference<Activity> a() {
            return this.activityRef;
        }

        /* renamed from: b, reason: from getter */
        public final Float getAppliedMax() {
            return this.appliedMax;
        }

        /* renamed from: c, reason: from getter */
        public final Float getAppliedRate() {
            return this.appliedRate;
        }

        /* renamed from: d, reason: from getter */
        public final DisplayWindowHost getHost() {
            return this.host;
        }

        public final LinkedHashMap<Integer, Lease> e() {
            return this.leases;
        }

        /* renamed from: f, reason: from getter */
        public final int getLpType() {
            return this.lpType;
        }

        /* renamed from: g, reason: from getter */
        public final Float getOriginalRate() {
            return this.originalRate;
        }

        public final float h() {
            float rateHz = 0.0f;
            if (this.leases.isEmpty()) {
                Float f10 = this.originalMax;
                if (f10 != null) {
                    return f10.floatValue();
                }
                return 0.0f;
            }
            Lease leaseQ = q();
            if (leaseQ == null) {
                Float f11 = this.originalMax;
                if (f11 != null) {
                    return f11.floatValue();
                }
                return 0.0f;
            }
            if (leaseQ.getRateHz() <= 0.0f) {
                Float f12 = this.originalRate;
                if (f12 != null) {
                    rateHz = f12.floatValue();
                }
            } else {
                rateHz = leaseQ.getRateHz();
            }
            return Math.max(rateHz, 60.0f);
        }

        public final float i() {
            if (this.leases.isEmpty()) {
                Float f10 = this.originalRate;
                if (f10 != null) {
                    return f10.floatValue();
                }
                return 0.0f;
            }
            Lease leaseQ = q();
            if (leaseQ == null) {
                Float f11 = this.originalRate;
                if (f11 != null) {
                    return f11.floatValue();
                }
                return 0.0f;
            }
            if (leaseQ.getRateHz() > 0.0f) {
                return leaseQ.getRateHz();
            }
            Float f12 = this.originalRate;
            if (f12 != null) {
                return f12.floatValue();
            }
            return 0.0f;
        }

        public final void j(WeakReference<Activity> weakReference) {
            this.activityRef = weakReference;
        }

        public final void k(Float f10) {
            this.appliedMax = f10;
        }

        public final void l(Float f10) {
            this.appliedRate = f10;
        }

        public final void m(DisplayWindowHost displayWindowHost) {
            p.i(displayWindowHost, "<set-?>");
            this.host = displayWindowHost;
        }

        public final void n(int i10) {
            this.lpType = i10;
        }

        public final void o(Float f10) {
            this.originalMax = f10;
        }

        public final void p(Float f10) {
            this.originalRate = f10;
        }

        public final Lease q() {
            if (this.leases.isEmpty()) {
                return null;
            }
            Collection<Lease> collectionValues = this.leases.values();
            p.h(collectionValues, "<get-values>(...)");
            return (Lease) F.J0(collectionValues, new b(new a()));
        }
    }

    public static final Field n() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Field field = WindowManager.LayoutParams.class.getField("preferredMaxDisplayRefreshRate");
            field.setAccessible(true);
            objB = Result.b(field);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Field) objB;
    }

    public static final Float r() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Float.valueOf(View.class.getField("REQUESTED_FRAME_RATE_CATEGORY_DEFAULT").getFloat(null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Float) (Result.g(objB) ? null : objB);
    }

    public static final Method s() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(View.class.getMethod("setRequestedFrameRate", Float.TYPE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Method) objB;
    }

    public final AutoCloseable e(View anchor, OverlayRefreshPriority priority, float rateHz) {
        p.i(anchor, "anchor");
        p.i(priority, "priority");
        View rootView = anchor.getRootView();
        int iIncrementAndGet = nextId.incrementAndGet();
        synchronized (lock) {
            try {
                WeakHashMap<View, d> weakHashMap = windows;
                d dVar = weakHashMap.get(rootView);
                if (dVar == null) {
                    dVar = new d();
                    weakHashMap.put(rootView, dVar);
                }
                d dVar2 = dVar;
                e eVar = INSTANCE;
                p.f(rootView);
                eVar.i(rootView, anchor, dVar2);
                dVar2.e().put(Integer.valueOf(iIncrementAndGet), new Lease(priority.getRank(), rateHz));
                eVar.g(rootView, dVar2);
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return new b(rootView, iIncrementAndGet);
    }

    public final void f(d state, float target, float targetMax) {
        Activity activity;
        Window window;
        Object objB;
        WeakReference<Activity> weakReferenceA = state.a();
        if (weakReferenceA == null || (activity = weakReferenceA.get()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes.preferredRefreshRate == target) {
            p.f(attributes);
            if (o(attributes) == targetMax) {
                state.l(Float.valueOf(target));
                state.k(Float.valueOf(targetMax));
                return;
            }
        }
        attributes.preferredRefreshRate = target;
        p.f(attributes);
        t(attributes, targetMax);
        try {
            Result.Companion companion = Result.INSTANCE;
            window.setAttributes(attributes);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            INSTANCE.m(state, target, targetMax);
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "window.attributes failed", thE, false, 8, null);
        }
    }

    public final void g(View root, d state) {
        float fI = state.i();
        float fH = state.h();
        if (p.b(state.getAppliedRate(), fI) && p.b(state.getAppliedMax(), fH)) {
            return;
        }
        q(root, fI);
        int i10 = c.$EnumSwitchMapping$0[state.getHost().ordinal()];
        if (i10 == 1) {
            WeakReference<Activity> weakReferenceA = state.a();
            if ((weakReferenceA != null ? weakReferenceA.get() : null) != null) {
                f(state, fI, fH);
                return;
            } else {
                h(root, state, fI, fH);
                return;
            }
        }
        if (i10 == 2) {
            h(root, state, fI, fH);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            state.l(Float.valueOf(fI));
            state.k(Float.valueOf(fH));
        }
    }

    public final void h(View root, d state, float target, float targetMax) {
        Object objB;
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            state.l(Float.valueOf(target));
            state.k(Float.valueOf(targetMax));
            return;
        }
        if (layoutParams2.preferredRefreshRate == target && o(layoutParams2) == targetMax) {
            state.l(Float.valueOf(target));
            state.k(Float.valueOf(targetMax));
            return;
        }
        layoutParams2.preferredRefreshRate = target;
        t(layoutParams2, targetMax);
        Object systemService = root.getContext().getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager.updateViewLayout(root, layoutParams2);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            INSTANCE.m(state, target, targetMax);
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "updateViewLayout failed", thE, false, 8, null);
        }
    }

    public final void i(View root, View anchor, d state) {
        Window window;
        Float fValueOf = Float.valueOf(0.0f);
        if (state.getOriginalRate() != null) {
            return;
        }
        Triple<DisplayWindowHost, Activity, Integer> tripleB = a.b(root, anchor);
        DisplayWindowHost displayWindowHostA = tripleB.a();
        Activity activityB = tripleB.b();
        int iIntValue = tripleB.c().intValue();
        state.m(displayWindowHostA);
        state.n(iIntValue);
        int i10 = c.$EnumSwitchMapping$0[displayWindowHostA.ordinal()];
        if (i10 == 1) {
            WindowManager.LayoutParams attributes = (activityB == null || (window = activityB.getWindow()) == null) ? null : window.getAttributes();
            state.p(attributes != null ? Float.valueOf(attributes.preferredRefreshRate) : fValueOf);
            if (attributes != null) {
                fValueOf = Float.valueOf(o(attributes));
            }
            state.o(fValueOf);
            state.j(activityB != null ? new WeakReference<>(activityB) : null);
            if (activityB == null) {
                C4148a.u(TAG, "TYPE_BASE_APPLICATION 但取不到 Activity，回退 updateViewLayout", false, 4, null);
                return;
            }
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            state.p(fValueOf);
            state.o(fValueOf);
            return;
        }
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        state.p(layoutParams2 != null ? Float.valueOf(layoutParams2.preferredRefreshRate) : fValueOf);
        if (layoutParams2 != null) {
            fValueOf = Float.valueOf(o(layoutParams2));
        }
        state.o(fValueOf);
    }

    public final Field j() {
        return (Field) preferredMaxField.getValue();
    }

    public final Float k() {
        return (Float) requestedFrameRateDefault.getValue();
    }

    public final Method l() {
        return (Method) requestedFrameRateMethod.getValue();
    }

    public final void m(d state, float target, float targetMax) {
        state.l(Float.valueOf(target));
        state.k(Float.valueOf(targetMax));
        M6.c cVar = M6.c.INSTANCE;
        String strName = state.getHost().name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        p.h(lowerCase, "toLowerCase(...)");
        cVar.u(target, targetMax, lowerCase);
        String lowerCase2 = state.getHost().name().toLowerCase(locale);
        p.h(lowerCase2, "toLowerCase(...)");
        C4148a.k(TAG, "preferredRefreshRate=" + target + " preferredMaxDisplayRefreshRate=" + targetMax + " host=" + lowerCase2 + " lpType=" + state.getLpType() + " leases=" + state.e().size(), false, 4, null);
    }

    public final float o(WindowManager.LayoutParams layoutParams) {
        Object objB;
        Field fieldJ = j();
        if (fieldJ == null) {
            return 0.0f;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Float.valueOf(fieldJ.getFloat(layoutParams)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Float fValueOf = Float.valueOf(0.0f);
        if (Result.g(objB)) {
            objB = fValueOf;
        }
        return ((Number) objB).floatValue();
    }

    public final void p(View root, int id) {
        synchronized (lock) {
            try {
                WeakHashMap<View, d> weakHashMap = windows;
                d dVar = weakHashMap.get(root);
                if (dVar == null) {
                    return;
                }
                if (dVar.e().remove(Integer.valueOf(id)) == null) {
                    return;
                }
                INSTANCE.g(root, dVar);
                if (dVar.e().isEmpty()) {
                    weakHashMap.remove(root);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(View root, float target) {
        Object objB;
        Method methodL = l();
        if (methodL == null) {
            return;
        }
        if (target <= 0.0f) {
            Float fK = k();
            if (fK == null) {
                return;
            } else {
                target = fK.floatValue();
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(methodL.invoke(root, Float.valueOf(target)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "setRequestedFrameRate(" + target + ") failed", thE, false, 8, null);
        }
    }

    public final void t(WindowManager.LayoutParams layoutParams, float f10) {
        Object objB;
        Field fieldJ = j();
        if (fieldJ == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            fieldJ.setFloat(layoutParams, f10);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "set preferredMaxDisplayRefreshRate failed", thE, false, 8, null);
        }
    }
}
