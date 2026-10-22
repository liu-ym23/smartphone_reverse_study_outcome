package b5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import b5.c;
import java.util.List;

/* loaded from: classes.dex */
public interface d {
    void a(c.a aVar);

    View createView(ViewGroup viewGroup);

    CheckBox getCheckBox();

    List<Z4.d> getPermissions();

    TextView getTermsView();
}
