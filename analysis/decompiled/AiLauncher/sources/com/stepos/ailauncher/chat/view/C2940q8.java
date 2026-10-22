package com.stepos.ailauncher.chat.view;

import android.app.Activity;
import android.view.View;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.widget.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/view/q8;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "titleRes", "Lkotlin/Function0;", "LY8/t;", "onBack", "c", "(Landroid/app/Activity;ILp9/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.q8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2940q8 {
    public static final C2940q8 INSTANCE = new C2940q8();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(C2940q8 c2940q8, final Activity activity, int i10, InterfaceC5063a interfaceC5063a, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.o8
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2940q8.e(activity);
                }
            };
        }
        c2940q8.c(activity, i10, interfaceC5063a);
    }

    public static final Y8.t e(Activity activity) {
        activity.finish();
        return Y8.t.f7040a;
    }

    public static final void f(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public final void c(Activity activity, int titleRes, final InterfaceC5063a<Y8.t> onBack) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(onBack, "onBack");
        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) activity.findViewById(R$id.title_bar);
        stepOSTitleBar.setTitle(titleRes);
        stepOSTitleBar.setTitleGravity(1);
        stepOSTitleBar.addStartAction(R.drawable.stepos_icon_navigation_back, activity.getString(R$string.common_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.p8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2940q8.f(onBack, view);
            }
        });
    }
}
