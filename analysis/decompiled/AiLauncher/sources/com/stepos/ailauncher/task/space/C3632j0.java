package com.stepos.ailauncher.task.space;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u001b\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/task/space/j0;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "Lcom/stepos/ailauncher/task/space/e0;", DidiCardProvider.KEY_ITEMS, "s", "(Ljava/util/List;)V", "item", "p", "(Lcom/stepos/ailauncher/task/space/e0;)V", "", "memoryId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "u", "(Ljava/lang/String;Ljava/lang/String;)V", "r", "(Ljava/lang/String;)V", "", "empty", "t", "(Z)V", "Lcom/stepos/ailauncher/task/space/g0;", "adapter", "Lcom/stepos/ailauncher/task/space/g0;", "emptyView", "Landroid/view/View;", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.j0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3632j0 extends Fragment {
    private static final String ARG_TAB_TYPE = "tab_type";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final C3620g0 adapter = new C3620g0();
    private View emptyView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/task/space/j0$a;", "", "<init>", "()V", "", "tabType", "Lcom/stepos/ailauncher/task/space/j0;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/j0;", "ARG_TAB_TYPE", "Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.j0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C3632j0 a(String tabType) {
            kotlin.jvm.internal.p.i(tabType, "tabType");
            C3632j0 c3632j0 = new C3632j0();
            Bundle bundle = new Bundle();
            bundle.putString(C3632j0.ARG_TAB_TYPE, tabType);
            c3632j0.setArguments(bundle);
            return c3632j0;
        }

        public Companion() {
        }
    }

    public static final Y8.t q(C3632j0 c3632j0, MemoryItem item, int i10) {
        String string;
        com.stepos.ailauncher.sheet.nav.h hVarT4;
        kotlin.jvm.internal.p.i(item, "item");
        if (MemorySettingApi.INSTANCE.R()) {
            Bundle arguments = c3632j0.getArguments();
            if (arguments == null || (string = arguments.getString(ARG_TAB_TYPE)) == null) {
                string = "";
            }
            String str = string;
            androidx.fragment.app.r activity = c3632j0.getActivity();
            com.stepos.ailauncher.sheet.S s10 = activity instanceof com.stepos.ailauncher.sheet.S ? (com.stepos.ailauncher.sheet.S) activity : null;
            if (s10 != null && (hVarT4 = s10.t4()) != null) {
                MemoryFileEditFragment memoryFileEditFragmentA = MemoryFileEditFragment.INSTANCE.a(str, item.getContent(), item.getMemoryId(), item.getMemoryName(), item.e());
                String memoryId = item.getMemoryId();
                if (memoryId.length() == 0) {
                    memoryId = Const.STR_NEW;
                }
                com.stepos.ailauncher.sheet.nav.h.G(hVarT4, memoryFileEditFragmentA, "memory_edit_" + ((Object) memoryId), null, null, null, 28, null);
            }
        } else {
            Toast.makeText(c3632j0.requireContext(), R$string.memory_share_disabled_toast, 0).show();
        }
        return Y8.t.f7040a;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        r6.h hVarC = r6.h.c(inflater, container, false);
        kotlin.jvm.internal.p.h(hVarC, "inflate(...)");
        RecyclerView rvMemoryList = hVarC.rvMemoryList;
        kotlin.jvm.internal.p.h(rvMemoryList, "rvMemoryList");
        this.emptyView = hVarC.tvEmpty;
        rvMemoryList.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvMemoryList.setAdapter(this.adapter);
        t(this.adapter.getItemCount() == 0);
        this.adapter.g(new p9.p() { // from class: com.stepos.ailauncher.task.space.i0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return C3632j0.q(this.f29038a, (MemoryItem) obj, ((Integer) obj2).intValue());
            }
        });
        FrameLayout frameLayoutB = hVarC.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        return frameLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.emptyView = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_TAB_TYPE)) == null) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        AmooMemoryDetailFragment amooMemoryDetailFragment = parentFragment instanceof AmooMemoryDetailFragment ? (AmooMemoryDetailFragment) parentFragment : null;
        if (amooMemoryDetailFragment != null) {
            amooMemoryDetailFragment.I(this, string);
        }
    }

    public final void p(MemoryItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        this.adapter.c(item);
        t(false);
    }

    public final void r(String memoryId) {
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        if (this.adapter.f(memoryId)) {
            t(this.adapter.getItemCount() == 0);
        }
    }

    public final void s(List<MemoryItem> items) {
        kotlin.jvm.internal.p.i(items, "items");
        this.adapter.submitList(items);
        t(items.isEmpty());
    }

    public final void t(boolean empty) {
        View view = this.emptyView;
        if (view != null) {
            view.setVisibility(empty ? 0 : 8);
        }
    }

    public final void u(String memoryId, String content) {
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        kotlin.jvm.internal.p.i(content, "content");
        C3620g0 c3620g0 = this.adapter;
        String string = getString(R$string.memory_time_just_now);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        c3620g0.h(memoryId, content, string);
    }
}
