package g9;

import android.view.View;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f20023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20026d;

    @JvmOverloads
    public a(@NotNull View.OnClickListener r10) {
        q.g(r10, "listener");
        int r11 = 0;
        this(r10, r11, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        long r11 = System.currentTimeMillis();
        long r12 = this.f20026d;
        if (r11 >= r12) goto L5;
    L6:
        this.f20025c = 0;
    L7:
        this.f20026d = r11;
        int r13 = this.f20025c + 1;
        this.f20025c = r13;
        if (r13 < this.f20024b) goto L11;
        this.f20025c = 0;
        this.f20026d = 0;
        this.f20023a.onClick(r10);
        return;
    L11:
        return;
    L5:
        if ((r11 - r12) <= 500) goto L7;
        goto L6
    }

    public a(View.OnClickListener r10, int r11) {
        q.g(r10, "listener");
        this.f20023a = r10;
        this.f20024b = r11;
    }

    public /* synthetic */ a(View.OnClickListener r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 5;
    L5:
        this(r10, r11);
    }
}
