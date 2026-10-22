package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteSearchContract$View;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/BaseTalkInviteSearchFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkInviteSearchContract$View;", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseTalkInviteSearchFragment extends BaseTalkInviteSearchContract$View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IRoom f74855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f74856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EditText f74857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f74858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f74859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MultiTypeAdapter f74860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList<Object> f74861m;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTalkInviteSearchFragment f74862a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(BaseTalkInviteSearchFragment r100) {
            this.f74862a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (TextUtils.isEmpty(r100) == false) goto L7;
            TextView r104 = this.f74862a.f74859k;
            if (r104 == null) goto L11;
            r104.setVisibility(0);
            return;
        L11:
            return;
        L7:
            TextView r105 = this.f74862a.f74859k;
            if (r105 == null) goto L13;
            r105.setVisibility(8);
            return;
        }
    }

    public static final class b implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTalkInviteSearchFragment f74863a;

        public b(BaseTalkInviteSearchFragment r100) {
            this.f74863a = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            if (r101 != 66) goto L12;
            if (r102 != null) goto L6;
        L7:
            BaseTalkInviteSearchFragment r103 = this.f74863a;
            EditText r104 = r103.f74857i;
            if (r104 == null) goto L14;
            yf0.d r105 = (yf0.d) r103.f74349f;
            r104.getText().toString();
            r105.d();
            return false;
        L14:
            return false;
        L6:
            if (r102.getAction() != 1) goto L7;
            return false;
        L12:
            return false;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTalkInviteSearchFragment f74864a;

        public c(BaseTalkInviteSearchFragment r100) {
            this.f74864a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f74864a.f74861m.clear();
            MultiTypeAdapter r101 = this.f74864a.f74860l;
            if (r101 == null) goto L5;
            r101.notifyDataSetChanged();
        L5:
            EditText r102 = this.f74864a.f74857i;
            if (r102 == null) goto L9;
            r102.setText("");
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    public BaseTalkInviteSearchFragment() {
        this.f74861m = new LinkedList();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        t2.a(getContext(), this.f74857i);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Room r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        this.f74855g = r101;
        if (r101 == null) goto L5;
        String r102 = r101.getOwnerUserIdString();
    L6:
        Intrinsics.areEqual(r102, ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n());
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.error);
        this.f74856h = (RecyclerView) r100.findViewById(R.id.recycler_view);
        this.f74857i = (EditText) r100.findViewById(R.id.invite_search_edt);
        TextView r103 = (TextView) r100.findViewById(R.id.close_btn);
        this.f74858j = (ImageView) r100.findViewById(R.id.clear_iv);
        LinearLayout r104 = (LinearLayout) r100.findViewById(R.id.empty);
        this.f74859k = (TextView) r100.findViewById(R.id.hint_tv);
        MultiTypeAdapter r105 = new MultiTypeAdapter();
        this.f74860l = r105;
        RecyclerView r106 = this.f74856h;
        if (r106 == null) goto L5;
        r106.setAdapter(r105);
    L5:
        RecyclerView r107 = this.f74856h;
        if (r107 == null) goto L8;
        r107.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        MultiTypeAdapter r108 = this.f74860l;
        if (r108 == null) goto L11;
        r108.A2(this.f74861m);
    L11:
        EditText r109 = this.f74857i;
        if (r109 == null) goto L14;
        r109.addTextChangedListener(new a(this));
    L14:
        EditText r110 = this.f74857i;
        if (r110 == null) goto L17;
        r110.setOnKeyListener(new b(this));
    L17:
        ImageView r111 = this.f74858j;
        if (r111 == null) goto L21;
        r111.setOnClickListener(new c(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_interact_base_talk_invite_search, r101, false);
    }
}
