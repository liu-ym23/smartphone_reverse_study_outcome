package w2;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.stepos.common.widget.Switch;
import com.stepos.familyguard.R;

/* renamed from: w2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1213c {
    public static /* synthetic */ void a(stepos.support.v7.app.c cVar, CompoundButton compoundButton, boolean z5) throws InterruptedException {
        cVar.getButton(-1).setEnabled(z5);
        if (z5) {
            p2.g.W(true);
        }
    }

    private static View c(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.us_alert_dialog_alphame_item, (ViewGroup) null, false);
    }

    public static stepos.support.v7.app.c d(Context context, DialogInterface.OnClickListener onClickListener) {
        C2.b bVar = new C2.b(context);
        View viewC = c(context);
        final stepos.support.v7.app.c cVarC = bVar.x(R.string.us_alphame_alert_title).z(viewC).u(R.string.us_agree_and_use, onClickListener).o(R.string.us_refuse, new DialogInterface.OnClickListener() { // from class: w2.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.cancel();
            }
        }).g(false).c();
        ((Switch) viewC.findViewById(R.id.switcher)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: w2.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) throws InterruptedException {
                C1213c.a(cVarC, compoundButton, z5);
            }
        });
        cVarC.show();
        return cVarC;
    }
}
