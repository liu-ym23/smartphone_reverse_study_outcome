package K;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.stepos.alphame.utils.NavigationBarUtils;

/* renamed from: K.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0090w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1011a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1012b;

    public /* synthetic */ RunnableC0090w(int i4, View view) {
        this.f1011a = i4;
        this.f1012b = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f1011a;
        int i5 = 0;
        Object[] objArr = 0;
        View view = this.f1012b;
        switch (i4) {
            case 0:
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                break;
            case 1:
                view.requestFocus();
                view.post(new com.google.android.material.internal.m(i5, view, objArr == true ? 1 : 0));
                break;
            default:
                NavigationBarUtils.lambda$checkNavigationBarHeight$0(view);
                break;
        }
    }
}
