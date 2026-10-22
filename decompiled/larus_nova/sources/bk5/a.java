package bk5;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    UserSession e9();

    void f9(Fragment r100);

    void g9(String r100, int r101, Integer r102, String r103, Function0<Unit> r104);

    Activity getActivity();

    Fragment getFragment();

    String getTAG();

    Bundle h9();

    void hideLoading();

    void i9(yx4.d r100);

    vo5.a j9();

    void o0(Bundle r100);

    void showLoading();

    void terminate();

    void w();

    void x();
}
