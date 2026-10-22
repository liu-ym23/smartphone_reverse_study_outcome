package Ic;

import Ic.c;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes5.dex */
public interface d {
    void a(c.a aVar);

    View createView(ViewGroup viewGroup);

    CheckBox getCheckBox();

    List<stepos.support.v7.permission.d> getPermissions();

    TextView getTermsView();
}
