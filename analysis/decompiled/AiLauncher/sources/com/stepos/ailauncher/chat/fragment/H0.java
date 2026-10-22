package com.stepos.ailauncher.chat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.view.ArtifactsView;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import java.util.ArrayList;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R(\u0010$\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u001fj\n\u0012\u0004\u0012\u00020 \u0018\u0001`!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/H0;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "D", "()Ljava/lang/String;", "sessionId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "c", "supportsSheetHalfSettle", "e", "extendsContentToBottomEdge", "m", "hidesResidentInput", "Ljava/util/ArrayList;", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Lkotlin/collections/ArrayList;", "C", "()Ljava/util/ArrayList;", "seededArtifacts", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H0 extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_ARTIFACTS = "artifacts";
    private static final String ARG_SESSION_ID = "session_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/H0$a;", "", "<init>", "()V", "", "sessionId", "Ljava/util/ArrayList;", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Lkotlin/collections/ArrayList;", H0.ARG_ARTIFACTS, "Lcom/stepos/ailauncher/chat/fragment/H0;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/ArrayList;)Lcom/stepos/ailauncher/chat/fragment/H0;", "ARG_SESSION_ID", "Ljava/lang/String;", "ARG_ARTIFACTS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.H0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final H0 a(String sessionId, ArrayList<SessionArtifact> artifacts) {
            H0 h02 = new H0();
            Bundle bundle = new Bundle();
            if (sessionId != null && sessionId.length() != 0) {
                bundle.putString("session_id", sessionId);
            }
            if (artifacts != null && !artifacts.isEmpty()) {
                bundle.putParcelableArrayList(H0.ARG_ARTIFACTS, artifacts);
            }
            h02.setArguments(bundle);
            return h02;
        }

        public Companion() {
        }
    }

    private final String D() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("session_id")) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static final Y8.t E(H0 h02) {
        h02.x();
        return Y8.t.f7040a;
    }

    public static final Y8.t F(H0 h02, SessionArtifact artifact) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        androidx.fragment.app.r activity = h02.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.n8(artifact, M5.c.SOURCE_ARTIFACT_SHEET);
        }
        return Y8.t.f7040a;
    }

    public final ArrayList<SessionArtifact> C() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getParcelableArrayList(ARG_ARTIFACTS, SessionArtifact.class);
        }
        return null;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean c() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean m() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        return new ArtifactsView(contextRequireContext, null, 0, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ArtifactsView artifactsView = (ArtifactsView) view;
        artifactsView.setOnExit(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.F0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return H0.E(this.f25171a);
            }
        });
        artifactsView.setOnArtifactClick(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.G0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H0.F(this.f25173a, (SessionArtifact) obj);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        artifactsView.j(viewLifecycleOwner, D(), C());
    }
}
