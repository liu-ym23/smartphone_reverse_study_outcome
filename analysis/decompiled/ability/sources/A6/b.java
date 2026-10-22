package A6;

import android.os.Message;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.t;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity;
import com.stepos.common.widget.Switch;
import com.stepos.widget.list.StepOSListItem;
import com.zyql.common.utils.update.UpdateProgressDialog;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f110a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f110a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        int i = this.f110a;
        Message messageObtain = null;
        Object obj = this.b;
        switch (i) {
            case 0:
                f fVar = (f) obj;
                if (view == fVar.f141t && (message3 = fVar.f142v) != null) {
                    messageObtain = Message.obtain(message3);
                } else if (view == fVar.f143w && (message2 = fVar.y) != null) {
                    messageObtain = Message.obtain(message2);
                } else if (view == fVar.f145z && (message = fVar.f115B) != null) {
                    messageObtain = Message.obtain(message);
                }
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                fVar.f134V.obtainMessage(1, fVar.b).sendToTarget();
                break;
            case 1:
                StepOSListItem stepOSListItem = (StepOSListItem) obj;
                F6.f fVar2 = stepOSListItem.f;
                if (fVar2 != null) {
                    fVar2.b(stepOSListItem);
                    break;
                }
                break;
            case 2:
                int i6 = VoiceWakeSettingActivity.f3343j;
                ((VoiceWakeSettingActivity) obj).finish();
                break;
            case 3:
                WakeupWordSelectionActivity wakeupWordSelectionActivity = (WakeupWordSelectionActivity) obj;
                int i10 = WakeupWordSelectionActivity.f;
                if (wakeupWordSelectionActivity.q()) {
                    com.stepos.statsrpk.d.n("wakeword_select", "cancel");
                }
                wakeupWordSelectionActivity.finish();
                break;
            case 4:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) obj;
                EditText editText = cVar.i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    cVar.q();
                    break;
                }
                break;
            case 5:
                ((com.google.android.material.textfield.j) obj).u();
                break;
            case 6:
                t tVar = (t) obj;
                EditText editText2 = tVar.f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = tVar.f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        tVar.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        tVar.f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        tVar.f.setSelection(selectionEnd);
                    }
                    tVar.q();
                    break;
                }
                break;
            case 7:
                ((Switch) obj).toggle();
                break;
            case 8:
                ((S7.a) obj).invoke();
                break;
            default:
                UpdateProgressDialog.onCreate$lambda$7$lambda$6((UpdateProgressDialog) obj, view);
                break;
        }
    }
}
