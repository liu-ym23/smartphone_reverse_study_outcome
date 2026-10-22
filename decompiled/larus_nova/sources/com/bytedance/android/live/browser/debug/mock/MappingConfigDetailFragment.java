package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q20.j;
import r20.c;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigDetailFragment;", "Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MappingConfigDetailFragment extends BaseDialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f62625e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f62626d;

    public static final class a {
        public static void a(FragmentActivity r100, Uri r101, Uri r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "originUri");
            Bundle r103 = new Bundle();
            MappingConfigDetailFragment r104 = new MappingConfigDetailFragment();
            r103.putParcelable("origin_uri", r101);
            r103.putParcelable("mapping_uri", r102);
            r104.setArguments(r103);
            LiveDialogFragment.Companion.getClass();
            LiveDialogFragment.a.a(r100, r104);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MappingConfigDetailFragment f62627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f62628b;

        public b(MappingConfigDetailFragment r100, Uri r101) {
            this.f62627a = r100;
            this.f62628b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            EditText r101 = (EditText) this.f62627a.S90(R.id.mapping_to_url);
            if (r101 != null) goto L10;
            return;
        L10:
            UriProtector.parse(r101.getText().toString());     // Catch: Exception -> L7
            Map<String, String> r102 = c.f535713a;
            int r103 = j.f531349a;
            ((HashMap) r102).put(j.a(this.f62628b), r101.getText().toString());
            e<Map<String, String>> r104 = com.bytedance.android.livesdk.sharedpref.b.f158227w;
            r104.getClass();
            f.d(r104, r102);
            f2.i(this.f62627a.getActivity(), "保存成功", 0);
            return;
        L7:
            e = move-exception;
            Toast.makeText(this.f62627a.getActivity(), "输入的正确的url,error:" + e.getMessage(), 0).show();
        }
    }

    static {
    }

    public MappingConfigDetailFragment() {
        this.f62626d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f62626d).clear();
    }

    public final View S90(int r100) {
        if (this.f62626d != null) goto L5;
        this.f62626d = new LinkedHashMap();
    L5:
        View r101 = this.f62626d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f62626d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        r101.getString("param1");
        r101.getString("param2");
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get("origin_uri");
    L6:
        if (r104 == null) goto L26;
        Uri r105 = (Uri) r104;
        Bundle r106 = getArguments();
        if (r106 == null) goto L10;
        Object r107 = r106.get("mapping_uri");
    L12:
        if ((r107 instanceof Uri) == false) goto L15;
        r103 = r107;
    L15:
        Uri r108 = (Uri) r103;
        if (r108 == null) goto L18;
        ((EditText) S90(R.id.mapping_to_url)).setText(r108.toString());
    L18:
        TextView r109 = (TextView) S90(R.id.origin_url);
        if (r109 == null) goto L21;
        r109.setText("原URI:" + r105);
    L21:
        TextView r110 = (TextView) S90(R.id.edit_done);
        if (r110 == null) goto L27;
        r110.setOnClickListener(new b(this, r105));
        return;
    L27:
        return;
    L10:
        r107 = null;
        goto L12
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_mapping_config_detail, r101, false);
    }
}
