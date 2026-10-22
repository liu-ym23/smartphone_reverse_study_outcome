package A6;

import F9.C0234l;
import a.AbstractC0291a;
import a7.AbstractC0308d;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.preference.PreferenceViewHolder;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSSwitchPreference;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.object.UploadPartBasicInput;
import com.volcengine.tos.model.object.UploadPartCopyV2Input;
import com.volcengine.tos.model.object.UploadPartCopyV2Output;
import com.volcengine.tos.model.object.UploadPartV2Output;
import java.io.IOException;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements NestedScrollView.OnScrollChangeListener, F6.g, X6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f109a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f109a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // F6.g
    public void a(StepOSListItem stepOSListItem, boolean z10) {
        StepOSSwitchPreference stepOSSwitchPreference = (StepOSSwitchPreference) this.b;
        PreferenceViewHolder preferenceViewHolder = (PreferenceViewHolder) this.c;
        if (z10 == stepOSSwitchPreference.isChecked()) {
            return;
        }
        L6.a aVar = stepOSListItem.f4135t;
        boolean z11 = aVar != null && (aVar.f936a || aVar.b) && stepOSSwitchPreference.isEnabled() && stepOSSwitchPreference.isSelectable();
        if (!stepOSSwitchPreference.callChangeListener(Boolean.valueOf(z10))) {
            stepOSListItem.setSwitchChecked(stepOSSwitchPreference.isChecked());
            return;
        }
        stepOSSwitchPreference.setChecked(z10);
        if (z11) {
            H6.a aVar2 = stepOSSwitchPreference.d;
            aVar2.getClass();
            boolean z12 = aVar2.f755a;
            aVar2.f755a = true;
            try {
                preferenceViewHolder.itemView.callOnClick();
            } finally {
                aVar2.f755a = z12;
            }
        }
    }

    @Override // X6.a
    public Object c(TosResponse tosResponse) throws IOException {
        switch (this.f109a) {
            case 2:
                C0234l c0234l = (C0234l) this.b;
                UploadPartBasicInput uploadPartBasicInput = (UploadPartBasicInput) this.c;
                c0234l.getClass();
                return new UploadPartV2Output().setRequestInfo(tosResponse.b()).setPartNumber(uploadPartBasicInput.getPartNumber()).setEtag(tosResponse.c("ETag")).setSsecAlgorithm(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Algorithm")).setSsecKeyMD5(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Key-MD5")).setHashCrc64ecma(tosResponse.c("x-tos-hash-crc64ecma"));
            default:
                C0234l c0234l2 = (C0234l) this.b;
                UploadPartCopyV2Input uploadPartCopyV2Input = (UploadPartCopyV2Input) this.c;
                c0234l2.getClass();
                String strI = AbstractC0291a.I(tosResponse.d, "copy result");
                try {
                    if (AbstractC0308d.b(strI, new X6.e()) != null) {
                        throw new ClassCastException();
                    }
                    new UploadPartCopyV2Output().requestInfo(tosResponse.b()).copySourceVersionID(tosResponse.c("X-Tos-Copy-Source-Version-Id")).partNumber(uploadPartCopyV2Input.getPartNumber());
                    throw null;
                } catch (TosClientException unused) {
                    if (AbstractC0308d.b(strI, new X6.e()) == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                }
        }
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView v10, int i, int i6, int i10, int i11) {
        View view = (View) this.b;
        View view2 = (View) this.c;
        kotlin.jvm.internal.k.f(v10, "v");
        F.i.w(v10, view, view2);
    }
}
