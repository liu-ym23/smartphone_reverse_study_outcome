package acc;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.widget.mark.MarkView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MarkView f2921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MarkView f2922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f2923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f2924f;

    public b(int r100, int r101, MarkView r102, MarkView r103, Context r104) {
        this.f2919a = r100;
        this.f2920b = r101;
        this.f2921c = r102;
        this.f2922d = r103;
        this.f2923e = false;
        this.f2924f = r104;
    }

    public final void a() {
        if (a.c(this.f2919a, this.f2920b, this.f2921c.getWidth()) == false) goto L5;
        int r100 = 0;
    L6:
        this.f2921c.setVisibility(r100);
        MarkView r101 = this.f2921c;
        MarkView r102 = this.f2922d;
        Intrinsics.checkNotNullParameter(r101, "cleanedTipView");
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L17;
        if (r101.getVisibility() != 0) goto L17;
        r102.setVisibility(8);
    L17:
        if (this.f2923e == false) goto L25;
        MarkView r104 = this.f2922d;
        if (r104 == null) goto L21;
        r104.setText(UIUtils.getString(this.f2924f, R.string.Lark_Groups_PostPhotostrip));
    L21:
        MarkView r105 = this.f2922d;
        if (r105 == null) goto L26;
        r105.setVisibility(0);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        if (r102.getVisibility() != 0) goto L11;
        r103 = true;
        goto L12
    L5:
        r100 = 8;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
