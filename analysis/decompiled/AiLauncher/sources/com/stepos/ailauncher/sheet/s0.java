package com.stepos.ailauncher.sheet;

import Z8.C1173v;
import android.app.Activity;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.s0;
import com.stepos.ailauncher.sheet.widget.DraggableSheetLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 Y2\u00020\u0001:\u0002Z[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J!\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u0003J%\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\f¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\b¢\u0006\u0004\b*\u0010\u0003J?\u0010/\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010+2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010-¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\b¢\u0006\u0004\b1\u0010\u0003J\r\u00102\u001a\u00020\u0006¢\u0006\u0004\b2\u0010)J\u0015\u00103\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u00020\u00062\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u001f¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00062\u0006\u00105\u001a\u00020\f¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\b¢\u0006\u0004\b;\u0010\u0003J\r\u0010<\u001a\u00020\b¢\u0006\u0004\b<\u0010\u0003J\u0015\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u001f¢\u0006\u0004\b>\u0010'J\r\u0010?\u001a\u00020\b¢\u0006\u0004\b?\u0010\u0003J\r\u0010@\u001a\u00020\b¢\u0006\u0004\b@\u0010\u0003J9\u0010F\u001a\u00020E2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u00062\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0-¢\u0006\u0004\bF\u0010GJS\u0010M\u001a\u00020L2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00122\u0006\u0010I\u001a\u00020H2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0-2\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0J¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\b¢\u0006\u0004\bO\u0010\u0003J\u001d\u0010Q\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020\u0012¢\u0006\u0004\bQ\u0010RR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010W¨\u0006\\"}, d2 = {"Lcom/stepos/ailauncher/sheet/s0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sheet/s0$b;", "entry", "", "covered", "LY8/t;", "s", "(Lcom/stepos/ailauncher/sheet/s0$b;Z)V", "H", "", "stackSize", "animate", "l", "(IZ)V", "Q", "", "depth", "P", "(F)F", "liftPx", "z", "(FF)F", "k", "n", "(Lcom/stepos/ailauncher/sheet/s0$b;)F", "R", "()I", "p", "Landroid/app/Activity;", "activity", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "sheetLayout", "layer", "J", "(Landroid/app/Activity;Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;I)V", "C", "(Landroid/app/Activity;)V", "o", "()Z", "u", "Lkotlin/Function0;", "onRevealed", "Lkotlin/Function1;", "onCovered", "L", "(Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;Lp9/a;Lp9/l;)V", ExifInterface.LONGITUDE_EAST, "x", "y", "(Landroid/app/Activity;)Z", "taskId", "except", "w", "(ILandroid/app/Activity;)Z", "v", "(I)Z", "G", "B", "top", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LONGITUDE_WEST, "N", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "enter", "onUpdate", "Landroidx/dynamicanimation/animation/i;", "q", "(FFZLp9/l;)Landroidx/dynamicanimation/animation/i;", "Lcom/stepos/ailauncher/sheet/g0;", "springSpec", "Lkotlin/Function2;", "onEnd", "Lcom/stepos/ailauncher/sheet/b0;", ExifInterface.LATITUDE_SOUTH, "(FFLcom/stepos/ailauncher/sheet/g0;Lp9/l;Lp9/p;)Lcom/stepos/ailauncher/sheet/b0;", "O", "progress", "t", "(Landroid/app/Activity;F)V", "", "stack", "Ljava/util/List;", "underlayContentRevealed", "Z", "homeGroupExitInProgress", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s0 {
    private static final float CONTENT_HIDE_PROGRESS = 0.005f;
    private static final float CONTENT_REVEAL_PROGRESS = 0.015f;
    private static final float DAMPING = 0.88f;
    private static final float EXIT_DAMPING = 0.93f;
    private static final float EXIT_STIFFNESS = 400.0f;
    public static final float SCALE_STEP = 0.050000012f;
    public static final float STACK_PEEK_DP = 12.0f;
    private static final float STIFFNESS = 340.0f;
    private boolean homeGroupExitInProgress;
    private final List<Entry> stack = new ArrayList();
    private boolean underlayContentRevealed;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, s0> roots = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/sheet/s0$a;", "", "<init>", "()V", "", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/sheet/s0;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/sheet/s0;", "", "taskId", "Landroid/app/Activity;", "except", "", Const.INTENT_KEY_APIKEY, "(ILandroid/app/Activity;)Z", "", "SCALE_STEP", "F", "DAMPING", "STIFFNESS", "EXIT_DAMPING", "EXIT_STIFFNESS", "CONTENT_REVEAL_PROGRESS", "CONTENT_HIDE_PROGRESS", "Ljava/util/concurrent/ConcurrentHashMap;", "roots", "Ljava/util/concurrent/ConcurrentHashMap;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.s0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(int taskId, Activity except) {
            kotlin.jvm.internal.p.i(except, "except");
            if (taskId <= 0) {
                return false;
            }
            Collection collectionValues = s0.roots.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            Collection collection = collectionValues;
            if (collection.isEmpty()) {
                return false;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (((s0) it.next()).w(taskId, except)) {
                    return true;
                }
            }
            return false;
        }

        public final s0 b(String token) {
            Object objPutIfAbsent;
            kotlin.jvm.internal.p.i(token, "token");
            if (La.H.x0(token)) {
                token = "desktop";
            }
            ConcurrentHashMap concurrentHashMap = s0.roots;
            Object s0Var = concurrentHashMap.get(token);
            if (s0Var == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(token, (s0Var = new s0()))) != null) {
                s0Var = objPutIfAbsent;
            }
            kotlin.jvm.internal.p.h(s0Var, "getOrPut(...)");
            return (s0) s0Var;
        }

        public Companion() {
        }
    }

    public static final boolean D(Activity activity, Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.a() == activity;
    }

    public static final boolean F(Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getIsBase();
    }

    public static final boolean I(Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (it.getIsBase()) {
            return false;
        }
        Activity activityA = it.a();
        return activityA == null || activityA.isFinishing() || activityA.isDestroyed();
    }

    public static final boolean K(Activity activity, Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.a() == activity;
    }

    public static final boolean M(Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getIsBase();
    }

    public static final void T(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public static final void U(p9.p pVar, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        pVar.invoke(Boolean.valueOf(z10), Float.valueOf(f10));
    }

    public static final void V(androidx.dynamicanimation.animation.i iVar) {
        iVar.d();
    }

    public static /* synthetic */ void m(s0 s0Var, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        s0Var.l(i10, z10);
    }

    public static final void r(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public final void A(Activity top) {
        kotlin.jvm.internal.p.i(top, "top");
        H();
        if (this.homeGroupExitInProgress || this.stack.size() < 2 || ((Entry) Z8.F.C0(this.stack)).a() != top) {
            return;
        }
        Activity activityA = this.stack.get(C1173v.o(r2) - 1).a();
        O o10 = activityA instanceof O ? (O) activityA : null;
        if (o10 != null) {
            o10.z2();
        }
    }

    public final void B() {
        m(this, this.stack.size(), false, 2, null);
    }

    public final void C(final Activity activity) {
        InterfaceC5063a<Y8.t> interfaceC5063aD;
        kotlin.jvm.internal.p.i(activity, "activity");
        boolean zL = Z8.A.L(this.stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.k0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s0.D(activity, (s0.Entry) obj));
            }
        });
        H();
        if (!zL || this.stack.isEmpty() || this.homeGroupExitInProgress) {
            return;
        }
        Q();
        Entry entry = (Entry) Z8.F.E0(this.stack);
        Activity activityA = entry != null ? entry.a() : null;
        O o10 = activityA instanceof O ? (O) activityA : null;
        if (o10 != null) {
            o10.M2();
        }
        if (entry != null && entry.getIsBase() && (interfaceC5063aD = entry.d()) != null) {
            interfaceC5063aD.invoke();
        }
        W();
    }

    public final void E() {
        Object next;
        DraggableSheetLayout sheetLayout;
        if (!this.homeGroupExitInProgress) {
            Iterator<T> it = this.stack.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Entry) next).getIsBase()) {
                        break;
                    }
                }
            }
            Entry entry = (Entry) next;
            if (entry != null && (sheetLayout = entry.getSheetLayout()) != null) {
                sheetLayout.K(1.0f, 0.0f, 1.0f);
            }
        }
        Z8.A.L(this.stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.r0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s0.F((s0.Entry) obj));
            }
        });
        if (this.stack.isEmpty() || this.homeGroupExitInProgress) {
            return;
        }
        Q();
    }

    public final void G() {
        H();
        int size = this.stack.size() + 1;
        if (this.stack.isEmpty()) {
            return;
        }
        l(size, false);
    }

    public final void H() {
        Z8.A.L(this.stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.j0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s0.I((s0.Entry) obj));
            }
        });
    }

    public final void J(final Activity activity, DraggableSheetLayout sheetLayout, int layer) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(sheetLayout, "sheetLayout");
        H();
        Z8.A.L(this.stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.q0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s0.K(activity, (s0.Entry) obj));
            }
        });
        this.stack.add(new Entry(new WeakReference(activity), sheetLayout, layer, false, null, null, 56, null));
    }

    public final void L(DraggableSheetLayout sheetLayout, InterfaceC5063a<Y8.t> onRevealed, InterfaceC5074l<? super Boolean, Y8.t> onCovered) {
        kotlin.jvm.internal.p.i(sheetLayout, "sheetLayout");
        Z8.A.L(this.stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.l0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s0.M((s0.Entry) obj));
            }
        });
        sheetLayout.K(1.0f, 0.0f, 1.0f);
        this.stack.add(0, new Entry(null, sheetLayout, 1, true, onRevealed, onCovered));
        if (this.stack.size() > 1) {
            Q();
            W();
        }
    }

    public final void N() {
        H();
        if (this.stack.size() == 1 && ((Entry) Z8.F.q0(this.stack)).getIsBase()) {
            m(this, 1, false, 2, null);
            W();
        }
    }

    public final void O() {
        H();
        if (this.stack.isEmpty()) {
            return;
        }
        Q();
        W();
    }

    public final float P(float depth) {
        return 1.0f - (C5685n.m(depth, 0.0f, 1.0f) * 0.050000012f);
    }

    public final void Q() {
        m(this, this.stack.size(), false, 2, null);
    }

    public final int R() {
        H();
        return this.stack.size();
    }

    public final b0 S(float start, float end, SheetSpring springSpec, final InterfaceC5074l<? super Float, Y8.t> onUpdate, final p9.p<? super Boolean, ? super Float, Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(springSpec, "springSpec");
        kotlin.jvm.internal.p.i(onUpdate, "onUpdate");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        final androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(start));
        iVar.B(h0.d(springSpec, end));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.m0
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                s0.T(onUpdate, eVar, f10, f11);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.sheet.n0
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                s0.U(onEnd, eVar, z10, f10, f11);
            }
        });
        iVar.t();
        return new b0() { // from class: com.stepos.ailauncher.sheet.o0
            @Override // com.stepos.ailauncher.sheet.b0
            public final void cancel() {
                s0.V(iVar);
            }
        };
    }

    public final void W() {
        H();
        if (this.stack.isEmpty()) {
            return;
        }
        this.underlayContentRevealed = false;
        int iO = C1173v.o(this.stack);
        int i10 = 0;
        for (Object obj : this.stack) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            s((Entry) obj, i10 < iO);
            i10 = i11;
        }
    }

    public final float k(float depth) {
        if (depth <= 1.0f) {
            return 1.0f;
        }
        if (depth >= 2.0f) {
            return 0.0f;
        }
        return 2.0f - depth;
    }

    public final void l(int stackSize, boolean animate) {
        H();
        if (this.stack.isEmpty() || stackSize <= 0) {
            return;
        }
        i0 i0Var = i0.INSTANCE;
        SheetSpring sheetSpringX = i0Var.x();
        SheetSpring sheetSpringY = i0Var.y();
        int i10 = 0;
        for (Object obj : this.stack) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Entry entry = (Entry) obj;
            float f10 = C5685n.f((stackSize - 1) - i10, 0);
            float fP = P(f10);
            float fZ = z(f10, n(entry));
            float fK = k(f10);
            if (animate) {
                entry.getSheetLayout().B(fP, fZ, fK, sheetSpringX.getDampingRatio(), sheetSpringX.getStiffness(), sheetSpringY.getDampingRatio(), sheetSpringY.getStiffness());
            } else {
                entry.getSheetLayout().K(fP, fZ, fK);
            }
            i10 = i11;
        }
    }

    public final float n(Entry entry) {
        Integer numValueOf = Integer.valueOf(entry.getSheetLayout().getWidth());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        return (numValueOf != null ? numValueOf.intValue() : r1.getResources().getDisplayMetrics().widthPixels) * 0.034090135f;
    }

    public final boolean o() {
        if (this.homeGroupExitInProgress) {
            return false;
        }
        this.homeGroupExitInProgress = true;
        return true;
    }

    public final void p() {
        this.stack.clear();
    }

    public final androidx.dynamicanimation.animation.i q(float start, float end, boolean enter, final InterfaceC5074l<? super Float, Y8.t> onUpdate) {
        kotlin.jvm.internal.p.i(onUpdate, "onUpdate");
        float f10 = enter ? DAMPING : EXIT_DAMPING;
        float f11 = enter ? STIFFNESS : EXIT_STIFFNESS;
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(start));
        iVar.B(new androidx.dynamicanimation.animation.j(end).f(f10).h(f11));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.p0
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f12, float f13) {
                s0.r(onUpdate, eVar, f12, f13);
            }
        });
        return iVar;
    }

    public final void s(Entry entry, boolean covered) {
        Activity activityA = entry.a();
        O o10 = activityA instanceof O ? (O) activityA : null;
        if (o10 != null) {
            o10.P3(covered);
        }
        if (entry.getIsBase() && !kotlin.jvm.internal.p.d(entry.getLastCovered(), Boolean.valueOf(covered))) {
            entry.g(Boolean.valueOf(covered));
            InterfaceC5074l<Boolean, Y8.t> interfaceC5074lC = entry.c();
            if (interfaceC5074lC != null) {
                interfaceC5074lC.invoke(Boolean.valueOf(covered));
            }
        }
    }

    public final void t(Activity top, float progress) {
        int iNextIndex;
        kotlin.jvm.internal.p.i(top, "top");
        H();
        List<Entry> list = this.stack;
        ListIterator<Entry> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().a() == top) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            } else {
                iNextIndex = -1;
                break;
            }
        }
        if (iNextIndex > 0 && iNextIndex == C1173v.o(this.stack)) {
            float fM = C5685n.m(progress, 0.0f, 1.0f);
            boolean z10 = !this.underlayContentRevealed ? fM <= CONTENT_REVEAL_PROGRESS : fM <= CONTENT_HIDE_PROGRESS;
            this.underlayContentRevealed = z10;
            for (int i10 = 0; i10 < iNextIndex; i10++) {
                Entry entry = this.stack.get(i10);
                float f10 = (iNextIndex - i10) - fM;
                entry.getSheetLayout().K(P(f10), z(f10, n(entry)), k(f10));
                if (i10 == iNextIndex - 1) {
                    s(entry, !z10);
                }
            }
        }
    }

    public final void u() {
        if (this.homeGroupExitInProgress) {
            this.homeGroupExitInProgress = false;
            H();
            if (this.stack.isEmpty()) {
                return;
            }
            Q();
            W();
        }
    }

    public final boolean v(int taskId) {
        H();
        if (taskId <= 0) {
            return false;
        }
        List<Entry> list = this.stack;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Activity activityA = ((Entry) it.next()).a();
            if (activityA != null && activityA.getTaskId() == taskId) {
                return true;
            }
        }
        return false;
    }

    public final boolean w(int taskId, Activity except) {
        kotlin.jvm.internal.p.i(except, "except");
        H();
        if (taskId <= 0) {
            return false;
        }
        List<Entry> list = this.stack;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Activity activityA = ((Entry) it.next()).a();
            if (activityA != null && activityA != except && activityA.getTaskId() == taskId && !activityA.isFinishing() && !activityA.isDestroyed()) {
                return true;
            }
        }
        return false;
    }

    public final boolean x() {
        H();
        List<Entry> list = this.stack;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((Entry) it.next()).getIsBase()) {
                return true;
            }
        }
        return false;
    }

    public final boolean y(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        H();
        Entry entry = (Entry) Z8.F.E0(this.stack);
        return (entry != null ? entry.a() : null) == activity;
    }

    public final float z(float depth, float liftPx) {
        return (-liftPx) * C5685n.m(depth, 0.0f, 1.0f);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'R%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0013\u00103\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/sheet/s0$b;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "sheetLayout", "", "layer", "", "isBase", "Lkotlin/Function0;", "LY8/t;", "onRevealed", "Lkotlin/Function1;", "onCovered", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;IZLp9/a;Lp9/l;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/ref/WeakReference;", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "e", "()Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "I", "getLayer", "Z", "f", "()Z", "Lp9/a;", Const.INTENT_KEY_UMID, "()Lp9/a;", "Lp9/l;", "c", "()Lp9/l;", "lastCovered", "Ljava/lang/Boolean;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Boolean;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Boolean;)V", Const.INTENT_KEY_APIKEY, "()Landroid/app/Activity;", "activity", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.s0$b, reason: from toString */
    public static final /* data */ class Entry {
        private final WeakReference<Activity> activityRef;
        private final boolean isBase;
        private Boolean lastCovered;
        private final int layer;
        private final InterfaceC5074l<Boolean, Y8.t> onCovered;
        private final InterfaceC5063a<Y8.t> onRevealed;
        private final DraggableSheetLayout sheetLayout;

        /* JADX WARN: Multi-variable type inference failed */
        public Entry(WeakReference<Activity> weakReference, DraggableSheetLayout sheetLayout, int i10, boolean z10, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
            kotlin.jvm.internal.p.i(sheetLayout, "sheetLayout");
            this.activityRef = weakReference;
            this.sheetLayout = sheetLayout;
            this.layer = i10;
            this.isBase = z10;
            this.onRevealed = interfaceC5063a;
            this.onCovered = interfaceC5074l;
        }

        public final Activity a() {
            WeakReference<Activity> weakReference = this.activityRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        /* renamed from: b, reason: from getter */
        public final Boolean getLastCovered() {
            return this.lastCovered;
        }

        public final InterfaceC5074l<Boolean, Y8.t> c() {
            return this.onCovered;
        }

        public final InterfaceC5063a<Y8.t> d() {
            return this.onRevealed;
        }

        /* renamed from: e, reason: from getter */
        public final DraggableSheetLayout getSheetLayout() {
            return this.sheetLayout;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return kotlin.jvm.internal.p.d(this.activityRef, entry.activityRef) && kotlin.jvm.internal.p.d(this.sheetLayout, entry.sheetLayout) && this.layer == entry.layer && this.isBase == entry.isBase && kotlin.jvm.internal.p.d(this.onRevealed, entry.onRevealed) && kotlin.jvm.internal.p.d(this.onCovered, entry.onCovered);
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsBase() {
            return this.isBase;
        }

        public final void g(Boolean bool) {
            this.lastCovered = bool;
        }

        public int hashCode() {
            WeakReference<Activity> weakReference = this.activityRef;
            int iHashCode = (((((((weakReference == null ? 0 : weakReference.hashCode()) * 31) + this.sheetLayout.hashCode()) * 31) + Integer.hashCode(this.layer)) * 31) + Boolean.hashCode(this.isBase)) * 31;
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onRevealed;
            int iHashCode2 = (iHashCode + (interfaceC5063a == null ? 0 : interfaceC5063a.hashCode())) * 31;
            InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = this.onCovered;
            return iHashCode2 + (interfaceC5074l != null ? interfaceC5074l.hashCode() : 0);
        }

        public String toString() {
            return "Entry(activityRef=" + this.activityRef + ", sheetLayout=" + this.sheetLayout + ", layer=" + this.layer + ", isBase=" + this.isBase + ", onRevealed=" + this.onRevealed + ", onCovered=" + this.onCovered + ")";
        }

        public /* synthetic */ Entry(WeakReference weakReference, DraggableSheetLayout draggableSheetLayout, int i10, boolean z10, InterfaceC5063a interfaceC5063a, InterfaceC5074l interfaceC5074l, int i11, kotlin.jvm.internal.i iVar) {
            this(weakReference, draggableSheetLayout, i10, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? null : interfaceC5063a, (i11 & 32) != 0 ? null : interfaceC5074l);
        }
    }
}
