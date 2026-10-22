package com.stepos.ailauncher.chat.view;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\b\b*\u0001Z\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001`B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0013J\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\u0013J\u000f\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010\u0013J\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\u0013J\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\u0013J\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\u0013J\u0017\u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0014H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0014H\u0002¢\u0006\u0004\b4\u00103J\u0011\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020\u0014H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0014H\u0002¢\u0006\u0004\b;\u00103J\u001d\u0010>\u001a\u00020\n2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u001d¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\n¢\u0006\u0004\b@\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010BR\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010.R\u0016\u0010D\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010\u0016R\u0016\u0010J\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010\u0016R\u0016\u0010K\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010\u0016R\u0016\u0010L\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010\u0016R\u0016\u0010M\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010.R\u0016\u0010N\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010.R\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010.R\u0016\u0010Y\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010.R\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0011\u0010^\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b]\u00101¨\u0006a"}, d2 = {"Lcom/stepos/ailauncher/chat/view/e4;", "", "Landroidx/viewpager2/widget/ViewPager2;", "pager", "Landroidx/viewpager2/widget/ViewPager2$i;", "callback", "<init>", "(Landroidx/viewpager2/widget/ViewPager2;Landroidx/viewpager2/widget/ViewPager2$i;)V", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "y", "(I)V", "position", "x", "positionOffsetPixels", "D", "(II)V", "O", "()V", "", "velocity", "F", "(FF)I", ContentDisposition.Parameters.Size, "q", "(FI)F", "target", "startVelocity", "", "J", "(IF)Z", UxipConstants.f30680s, "B", "(FF)V", "excess", "p", "(FI)V", "r", "w", Const.INTENT_KEY_UMID, "N", "M", "G", "s", "Lcom/stepos/ailauncher/sheet/g0;", "I", "(I)Lcom/stepos/ailauncher/sheet/g0;", "C", "()I", "u", "()F", "v", "Landroidx/recyclerview/widget/RecyclerView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroidx/recyclerview/widget/RecyclerView;", "px", "o", "(F)V", "P", "page", "smooth", "H", "(IZ)V", ExifInterface.LONGITUDE_EAST, "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2$i;", "springTarget", "faking", "Z", "Landroidx/dynamicanimation/animation/i;", "spring", "Landroidx/dynamicanimation/animation/i;", "appliedPx", "springPx", "springVelocity", "scrollPx", "forwardedState", "forwardedSelection", "Ljava/lang/Runnable;", "competingScrollKill", "Ljava/lang/Runnable;", "", "sampleTime", "[J", "", "samplePx", "[F", "sampleHead", "sampleCount", "com/stepos/ailauncher/chat/view/e4$b", "observer", "Lcom/stepos/ailauncher/chat/view/e4$b;", "z", "currentPage", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.e4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2804e4 {
    private static final float MAX_OVERSHOOT_FRACTION = 0.06f;
    private static final float MAX_START_VELOCITY_PAGES_PER_SEC = 3.0f;
    private static final int NO_TARGET = -1;
    private static final int PAGE_CHAT = 1;
    private static final int PAGE_COUNT = 2;
    private static final int PAGE_SESSION_CENTER = 0;
    private static final int VELOCITY_SAMPLES = 5;
    private static final long VELOCITY_STALE_MS = 80;
    private static final long VELOCITY_WINDOW_MS = 100;
    private float appliedPx;
    private final ViewPager2.i callback;
    private final Runnable competingScrollKill;
    private boolean faking;
    private int forwardedSelection;
    private int forwardedState;
    private final b observer;
    private final ViewPager2 pager;
    private int sampleCount;
    private int sampleHead;
    private final float[] samplePx;
    private final long[] sampleTime;
    private float scrollPx;
    private androidx.dynamicanimation.animation.i spring;
    private float springPx;
    private int springTarget;
    private float springVelocity;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/view/e4$b", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "", "positionOffset", "positionOffsetPixels", "LY8/t;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "onPageScrollStateChanged", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.e4$b */
    public static final class b extends ViewPager2.i {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int state) {
            int i10 = C2804e4.this.forwardedState;
            if (state == 1 && C2804e4.this.faking) {
                C2804e4.this.y(2);
                return;
            }
            if (state == 1) {
                C2804e4.this.sampleCount = 0;
                C2804e4.this.y(state);
            } else if (state != 2 || C2804e4.this.faking || i10 != 1) {
                C2804e4.this.y(state);
            } else {
                C2804e4.this.y(state);
                C2804e4.this.O();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            C2804e4.this.D(position, positionOffsetPixels);
            C2804e4.this.callback.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            if (C2804e4.this.faking && C2804e4.this.pager.f() && position != C2804e4.this.springTarget) {
                return;
            }
            C2804e4.this.x(position);
        }
    }

    public C2804e4(ViewPager2 pager, ViewPager2.i callback) {
        kotlin.jvm.internal.p.i(pager, "pager");
        kotlin.jvm.internal.p.i(callback, "callback");
        this.pager = pager;
        this.callback = callback;
        this.springTarget = -1;
        this.scrollPx = Float.NaN;
        this.forwardedSelection = -1;
        this.competingScrollKill = new Runnable() { // from class: com.stepos.ailauncher.chat.view.d4
            @Override // java.lang.Runnable
            public final void run() {
                C2804e4.t(this.f26102a);
            }
        };
        this.sampleTime = new long[5];
        this.samplePx = new float[5];
        b bVar = new b();
        this.observer = bVar;
        pager.j(bVar);
    }

    public static final void K(C2804e4 c2804e4, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        c2804e4.B(f10, f11);
    }

    public static final void L(C2804e4 c2804e4, androidx.dynamicanimation.animation.i iVar, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (c2804e4.spring == iVar) {
            c2804e4.w();
        }
    }

    public static final void t(C2804e4 c2804e4) {
        if (c2804e4.faking && c2804e4.pager.f()) {
            c2804e4.M();
        }
    }

    public final RecyclerView A() {
        View childAt = this.pager.getChildAt(0);
        if (childAt instanceof RecyclerView) {
            return (RecyclerView) childAt;
        }
        return null;
    }

    public final void B(float value, float velocity) {
        this.springVelocity = velocity;
        this.springPx = value;
        int iC = C();
        if (iC <= 0) {
            d();
            return;
        }
        float fM = C5685n.m(value, 0.0f, iC * 1.0f);
        p(value - fM, iC);
        float f10 = fM - this.appliedPx;
        this.appliedPx = fM;
        if (this.pager.d(f10 * v())) {
            return;
        }
        d();
    }

    public final int C() {
        return (this.pager.getWidth() - this.pager.getPaddingLeft()) - this.pager.getPaddingRight();
    }

    public final void D(int position, int positionOffsetPixels) {
        int iC = C();
        if (iC <= 0) {
            return;
        }
        float f10 = (position * iC) + positionOffsetPixels;
        this.scrollPx = f10;
        if (this.faking) {
            return;
        }
        o(f10);
    }

    public final void E() {
        this.pager.r(this.observer);
        RecyclerView recyclerViewA = A();
        if (recyclerViewA != null) {
            recyclerViewA.removeCallbacks(this.competingScrollKill);
        }
        N();
    }

    public final int F(float position, float velocity) {
        float fB;
        double dFloor;
        float scaledMinimumFlingVelocity = ViewConfiguration.get(this.pager.getContext()).getScaledMinimumFlingVelocity();
        if (velocity > scaledMinimumFlingVelocity) {
            dFloor = Math.ceil(position);
        } else {
            if (velocity >= (-scaledMinimumFlingVelocity)) {
                fB = C5227b.b(position);
                return C5685n.n((int) fB, 0, 1);
            }
            dFloor = Math.floor(position);
        }
        fB = (float) dFloor;
        return C5685n.n((int) fB, 0, 1);
    }

    public final void G() {
        RecyclerView recyclerViewA = A();
        if (recyclerViewA == null) {
            return;
        }
        recyclerViewA.removeCallbacks(this.competingScrollKill);
        recyclerViewA.postOnAnimation(this.competingScrollKill);
    }

    public final void H(int page, boolean smooth) {
        if (!smooth) {
            N();
            this.pager.m(page, false);
        } else {
            if (this.springTarget == page) {
                return;
            }
            if (J(page, this.faking ? this.springVelocity : 0.0f) || this.pager.f()) {
                return;
            }
            this.pager.m(page, true);
        }
    }

    public final SheetSpring I(int target) {
        return target == 1 ? com.stepos.ailauncher.sheet.i0.INSTANCE.s() : com.stepos.ailauncher.sheet.i0.INSTANCE.t();
    }

    public final boolean J(int target, float startVelocity) {
        int iC = C();
        if (iC <= 0) {
            return false;
        }
        float fU = this.faking ? this.springPx : u();
        float f10 = target * iC;
        if (Math.abs(f10 - fU) <= 1.0f && Math.abs(startVelocity) <= 1.0f) {
            return false;
        }
        this.springPx = fU;
        if (!this.faking) {
            M();
            this.faking = true;
            this.appliedPx = fU;
            if (!this.pager.a()) {
                this.faking = false;
                return false;
            }
            G();
        }
        androidx.dynamicanimation.animation.i iVar = this.spring;
        this.spring = null;
        if (iVar != null) {
            iVar.d();
        }
        final androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(fU));
        iVar2.q(fU);
        iVar2.r(startVelocity);
        iVar2.o(1.0f);
        iVar2.B(com.stepos.ailauncher.sheet.h0.d(I(target), f10));
        iVar2.c(new e.r() { // from class: com.stepos.ailauncher.chat.view.b4
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f11, float f12) {
                C2804e4.K(this.f26074a, eVar, f11, f12);
            }
        });
        iVar2.b(new e.q() { // from class: com.stepos.ailauncher.chat.view.c4
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f11, float f12) {
                C2804e4.L(this.f26092a, iVar2, eVar, z10, f11, f12);
            }
        });
        this.springTarget = target;
        this.springVelocity = startVelocity;
        this.spring = iVar2;
        iVar2.t();
        x(target);
        return true;
    }

    public final void M() {
        RecyclerView recyclerViewA = A();
        if (recyclerViewA == null) {
            return;
        }
        recyclerViewA.stopScroll();
        recyclerViewA.stopScroll();
    }

    public final void N() {
        if (this.faking) {
            s();
            M();
        }
    }

    public final void O() {
        int iC = C();
        if (iC <= 0) {
            return;
        }
        float fU = u();
        float f10 = iC;
        float f11 = fU / f10;
        if (Math.abs(fU - (C5227b.b(f11) * f10)) <= 1.0f) {
            return;
        }
        float fP = P();
        int iF = F(f11, fP);
        if (J(iF, q(fP, iC)) || this.pager.f()) {
            return;
        }
        this.pager.m(iF, true);
    }

    public final float P() {
        if (this.sampleCount < 2) {
            return 0.0f;
        }
        int i10 = (this.sampleHead + 4) % 5;
        long j10 = this.sampleTime[i10];
        if (SystemClock.uptimeMillis() - j10 > 80) {
            return 0.0f;
        }
        int i11 = this.sampleCount;
        int i12 = 1;
        int i13 = i10;
        while (i12 < i11) {
            int i14 = ((i10 - i12) + 5) % 5;
            if (j10 - this.sampleTime[i14] > 100) {
                break;
            }
            i12++;
            i13 = i14;
        }
        long j11 = j10 - this.sampleTime[i13];
        if (j11 <= 0) {
            return 0.0f;
        }
        float[] fArr = this.samplePx;
        return ((fArr[i10] - fArr[i13]) / j11) * 1000.0f;
    }

    public final void d() {
        s();
        if (this.pager.getScrollState() == 1) {
            y(1);
        }
    }

    public final void o(float px) {
        this.sampleTime[this.sampleHead] = SystemClock.uptimeMillis();
        float[] fArr = this.samplePx;
        int i10 = this.sampleHead;
        fArr[i10] = px;
        this.sampleHead = (i10 + 1) % 5;
        int i11 = this.sampleCount;
        if (i11 < 5) {
            this.sampleCount = i11 + 1;
        }
    }

    public final void p(float excess, int size) {
        float f10 = size * MAX_OVERSHOOT_FRACTION;
        RecyclerView recyclerViewA = A();
        if (recyclerViewA != null) {
            recyclerViewA.setTranslationX(f10 * ((float) Math.tanh(excess / f10)) * v());
        }
    }

    public final float q(float velocity, int size) {
        float f10 = size * 3.0f;
        return C5685n.m(velocity, -f10, f10);
    }

    public final void r() {
        RecyclerView recyclerViewA = A();
        if (recyclerViewA != null) {
            recyclerViewA.setTranslationX(0.0f);
        }
    }

    public final void s() {
        androidx.dynamicanimation.animation.i iVar = this.spring;
        this.spring = null;
        this.springTarget = -1;
        this.springVelocity = 0.0f;
        this.faking = false;
        if (iVar != null) {
            iVar.d();
        }
        r();
        this.pager.b();
    }

    public final float u() {
        return Float.isNaN(this.scrollPx) ? this.pager.getCurrentItem() * C() : this.scrollPx;
    }

    public final float v() {
        return this.pager.getLayoutDirection() == 1 ? 1.0f : -1.0f;
    }

    public final void w() {
        this.spring = null;
        this.springTarget = -1;
        this.springVelocity = 0.0f;
        this.faking = false;
        r();
        this.pager.b();
    }

    public final void x(int position) {
        if (this.forwardedSelection == position) {
            return;
        }
        this.forwardedSelection = position;
        this.callback.onPageSelected(position);
    }

    public final void y(int state) {
        if (this.forwardedState == state) {
            return;
        }
        this.forwardedState = state;
        this.callback.onPageScrollStateChanged(state);
    }

    public final int z() {
        int i10 = this.springTarget;
        return i10 != -1 ? i10 : this.pager.getCurrentItem();
    }
}
