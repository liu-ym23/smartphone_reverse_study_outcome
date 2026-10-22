package com.stepos.ailauncher.task.space;

import Ua.C1060i;
import Z8.C1173v;
import android.content.Context;
import android.os.Bundle;
import android.view.C1398p;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.b;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.space.MemoryFileEditFragment;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 C2\u00020\u0001:\u0002DEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010!\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0003J+\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\r0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002080)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010?\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/stepos/ailauncher/task/space/j0;", "fragment", "", "tabType", "I", "(Lcom/stepos/ailauncher/task/space/j0;Ljava/lang/String;)V", "Q", "J", "", "hidden", "onHiddenChanged", "(Z)V", "Lcom/stepos/ailauncher/task/space/e0;", "item", "H", "(Lcom/stepos/ailauncher/task/space/e0;)V", "memoryId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Y", "(Ljava/lang/String;Ljava/lang/String;)V", "", "memoryIds", "R", "(Ljava/lang/String;Ljava/util/Set;)V", "onDestroyView", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "N", "P", "", "Lcom/stepos/ailauncher/task/space/h0;", "parsedItems", "X", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "L", "()Lcom/stepos/ailauncher/task/space/j0;", "Lr6/f;", "_binding", "Lr6/f;", "Lkotlinx/coroutines/g;", "loadJob", "Lkotlinx/coroutines/g;", "tabTypes", "Ljava/util/List;", "", "tabTitleRes", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "K", "()Lr6/f;", "binding", "M", "()I", "tabIndex", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooMemoryDetailFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_TAB_INDEX = "tab_index";
    public static final String NAV_TAG = "memory_detail_root";
    private static final String TAG = "AILauncher-MemoryDetail";
    private r6.f _binding;
    private kotlinx.coroutines.g loadJob;
    private final List<Integer> tabTitleRes;
    private final List<String> tabTypes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SimpleDateFormat dateFormatMD = new SimpleDateFormat("M/d", Locale.getDefault());
    private static final SimpleDateFormat dateFormatYMD = new SimpleDateFormat("yyyy/M/d", Locale.getDefault());

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment$a;", "", "<init>", "()V", "", "tabIndex", "Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment;", Const.INTENT_KEY_PKGNAME, "(I)Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment;", "Lcom/stepos/ailauncher/task/space/h0;", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/task/space/e0;", "c", "(Lcom/stepos/ailauncher/task/space/h0;Landroid/content/Context;)Lcom/stepos/ailauncher/task/space/e0;", "", "epochMs", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;J)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "ARG_TAB_INDEX", "NAV_TAG", "Ljava/text/SimpleDateFormat;", "dateFormatMD", "Ljava/text/SimpleDateFormat;", "dateFormatYMD", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(Context context, long epochMs) {
            if (epochMs <= 0) {
                return "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - epochMs;
            int i10 = Calendar.getInstance().get(1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(epochMs);
            int i11 = calendar.get(1);
            if (jCurrentTimeMillis < 60000) {
                String string = context.getString(R$string.memory_time_just_now);
                kotlin.jvm.internal.p.h(string, "getString(...)");
                return string;
            }
            if (jCurrentTimeMillis < Const.L_WIFI_EXP) {
                String string2 = context.getString(R$string.memory_time_minutes_ago, Long.valueOf(jCurrentTimeMillis / 60000));
                kotlin.jvm.internal.p.h(string2, "getString(...)");
                return string2;
            }
            if (jCurrentTimeMillis < 86400000) {
                String string3 = context.getString(R$string.memory_time_hours_ago, Long.valueOf(jCurrentTimeMillis / 3600000));
                kotlin.jvm.internal.p.h(string3, "getString(...)");
                return string3;
            }
            if (jCurrentTimeMillis < 172800000) {
                String string4 = context.getString(R$string.memory_time_yesterday);
                kotlin.jvm.internal.p.h(string4, "getString(...)");
                return string4;
            }
            if (jCurrentTimeMillis <= 604800000) {
                String string5 = context.getString(R$string.memory_time_days_ago, Long.valueOf(jCurrentTimeMillis / 86400000));
                kotlin.jvm.internal.p.h(string5, "getString(...)");
                return string5;
            }
            if (i11 == i10) {
                String str = AmooMemoryDetailFragment.dateFormatMD.format(new Date(epochMs));
                kotlin.jvm.internal.p.h(str, "format(...)");
                return str;
            }
            String str2 = AmooMemoryDetailFragment.dateFormatYMD.format(new Date(epochMs));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            return str2;
        }

        public final AmooMemoryDetailFragment b(int tabIndex) {
            AmooMemoryDetailFragment amooMemoryDetailFragment = new AmooMemoryDetailFragment();
            amooMemoryDetailFragment.setArguments(x0.c.a(Y8.j.a(AmooMemoryDetailFragment.ARG_TAB_INDEX, Integer.valueOf(tabIndex))));
            return amooMemoryDetailFragment;
        }

        public final MemoryItem c(MemoryItemParsed memoryItemParsed, Context context) {
            kotlin.jvm.internal.p.i(memoryItemParsed, "<this>");
            kotlin.jvm.internal.p.i(context, "context");
            return new MemoryItem(memoryItemParsed.getContent(), a(context, memoryItemParsed.getUpdatedAt()), memoryItemParsed.getMemoryId(), memoryItemParsed.getMemoryName(), memoryItemParsed.getIsPersistent(), memoryItemParsed.getUpdatedAt(), memoryItemParsed.d());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment$b;", "Landroidx/viewpager2/adapter/a;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "(Lcom/stepos/ailauncher/task/space/AmooMemoryDetailFragment;Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "", "getItemCount", "()I", "position", "Landroidx/fragment/app/Fragment;", "e", "(I)Landroidx/fragment/app/Fragment;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends androidx.viewpager2.adapter.a {
        final /* synthetic */ AmooMemoryDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AmooMemoryDetailFragment amooMemoryDetailFragment, FragmentManager fm, Lifecycle lifecycle) {
            super(fm, lifecycle);
            kotlin.jvm.internal.p.i(fm, "fm");
            kotlin.jvm.internal.p.i(lifecycle, "lifecycle");
            this.this$0 = amooMemoryDetailFragment;
        }

        @Override // androidx.viewpager2.adapter.a
        public Fragment e(int position) {
            return C3632j0.INSTANCE.a((String) this.this$0.tabTypes.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.this$0.tabTypes.size();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        final /* synthetic */ List $persistentKeys$inlined;

        public c(List list) {
            this.$persistentKeys$inlined = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iIndexOf = this.$persistentKeys$inlined.indexOf(((MemoryItemParsed) t10).getSlotKey());
            if (iIndexOf < 0) {
                iIndexOf = Integer.MAX_VALUE;
            }
            Integer numValueOf = Integer.valueOf(iIndexOf);
            int iIndexOf2 = this.$persistentKeys$inlined.indexOf(((MemoryItemParsed) t11).getSlotKey());
            return b9.b.d(numValueOf, Integer.valueOf(iIndexOf2 >= 0 ? iIndexOf2 : Integer.MAX_VALUE));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((MemoryItemParsed) t11).getUpdatedAt()), Long.valueOf(((MemoryItemParsed) t10).getUpdatedAt()));
        }
    }

    public AmooMemoryDetailFragment() {
        super(R$layout.fragment_amoo_memory_detail);
        this.tabTypes = C1173v.p("about_me", "communication", "memo");
        this.tabTitleRes = C1173v.p(Integer.valueOf(R$string.amoo_memory_about_me), Integer.valueOf(R$string.amoo_memory_communication), Integer.valueOf(R$string.amoo_memory_memo));
    }

    public static final void T(AmooMemoryDetailFragment amooMemoryDetailFragment, View view) {
        amooMemoryDetailFragment.x();
    }

    public static final void U(AmooMemoryDetailFragment amooMemoryDetailFragment, View view) {
        MemorySettingApi memorySettingApi = MemorySettingApi.INSTANCE;
        if (!memorySettingApi.R()) {
            Toast.makeText(amooMemoryDetailFragment.requireContext(), R$string.memory_share_disabled_toast, 0).show();
            return;
        }
        String str = amooMemoryDetailFragment.tabTypes.get(amooMemoryDetailFragment.K().viewPager.getCurrentItem());
        com.stepos.ailauncher.sheet.nav.a.z(amooMemoryDetailFragment, MemoryFileEditFragment.Companion.b(MemoryFileEditFragment.INSTANCE, str, "", null, memorySettingApi.X(str), null, 20, null), "memory_edit_new", null, null, null, 28, null);
    }

    public static final void W(AmooMemoryDetailFragment amooMemoryDetailFragment, TabLayout.g tab, int i10) {
        kotlin.jvm.internal.p.i(tab, "tab");
        tab.r(amooMemoryDetailFragment.getString(amooMemoryDetailFragment.tabTitleRes.get(i10).intValue()));
    }

    public final void H(MemoryItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        C3632j0 c3632j0L = L();
        if (c3632j0L != null) {
            c3632j0L.p(item);
        }
    }

    public final void I(C3632j0 fragment, String tabType) {
        kotlin.jvm.internal.p.i(fragment, "fragment");
        kotlin.jvm.internal.p.i(tabType, "tabType");
        List<MemoryItemParsed> listI = MemorySettingApi.INSTANCE.I(tabType);
        if (listI == null) {
            listI = C1173v.m();
        }
        fragment.s(X(listI, tabType));
    }

    public final void J() {
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.loadJob = null;
    }

    public final r6.f K() {
        r6.f fVar = this._binding;
        kotlin.jvm.internal.p.f(fVar);
        return fVar;
    }

    public final C3632j0 L() {
        int currentItem = K().viewPager.getCurrentItem();
        Fragment fragmentL0 = getChildFragmentManager().l0("f" + currentItem);
        if (fragmentL0 instanceof C3632j0) {
            return (C3632j0) fragmentL0;
        }
        return null;
    }

    public final int M() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return C5685n.n(arguments.getInt(ARG_TAB_INDEX, 0), 0, C1173v.o(this.tabTypes));
        }
        return 0;
    }

    public final void N() {
        int i10 = 0;
        C4148a.d(TAG, "loadCachedMemories: start", false, 4, null);
        for (Object obj : this.tabTypes) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            String str = (String) obj;
            Fragment fragmentL0 = getChildFragmentManager().l0("f" + i10);
            C3632j0 c3632j0 = fragmentL0 instanceof C3632j0 ? (C3632j0) fragmentL0 : null;
            if (c3632j0 != null) {
                I(c3632j0, str);
            }
            i10 = i11;
        }
    }

    public final void O() {
        N();
        P();
    }

    public final void P() {
        C4148a.d(TAG, "loadMemoriesFromNetwork: start", false, 4, null);
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.loadJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooMemoryDetailFragment$loadMemoriesFromNetwork$1(this, null), 3, null);
    }

    public final void Q() {
        if (this._binding != null) {
            O();
        }
    }

    public final void R(String tabType, Set<String> memoryIds) {
        kotlin.jvm.internal.p.i(tabType, "tabType");
        kotlin.jvm.internal.p.i(memoryIds, "memoryIds");
        int iIndexOf = this.tabTypes.indexOf(tabType);
        if (iIndexOf < 0) {
            return;
        }
        Fragment fragmentL0 = getChildFragmentManager().l0("f" + iIndexOf);
        C3632j0 c3632j0 = fragmentL0 instanceof C3632j0 ? (C3632j0) fragmentL0 : null;
        for (String str : memoryIds) {
            if (c3632j0 != null) {
                c3632j0.r(str);
            }
        }
    }

    public final void S() {
        K().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryDetailFragment.T(this.f29065a, view);
            }
        });
        K().btnAdd.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmooMemoryDetailFragment.U(this.f29077a, view);
            }
        });
    }

    public final void V() {
        ViewPager2 viewPager2 = K().viewPager;
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        viewPager2.setAdapter(new b(this, childFragmentManager, getViewLifecycleOwner().getLifecycle()));
        K().viewPager.setOffscreenPageLimit(this.tabTypes.size());
        new com.google.android.material.tabs.b(K().tabLayout, K().viewPager, new b.InterfaceC0238b() { // from class: com.stepos.ailauncher.task.space.m
            @Override // com.google.android.material.tabs.b.InterfaceC0238b
            public final void a(TabLayout.g gVar, int i10) {
                AmooMemoryDetailFragment.W(this.f29058a, gVar, i10);
            }
        }).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.ailauncher.task.space.MemoryItem> X(java.util.List<com.stepos.ailauncher.task.space.MemoryItemParsed> r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = -1035284522(0xffffffffc24acfd6, float:-50.702965)
            if (r0 == r1) goto L33
            r1 = 3347770(0x33153a, float:4.691225E-39)
            if (r0 == r1) goto L23
            r1 = 1619363722(0x6085878a, float:7.697449E19)
            if (r0 == r1) goto L14
            goto L3b
        L14:
            java.lang.String r0 = "about_me"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L3b
            com.stepos.ailauncher.task.space.MemorySettingApi r6 = com.stepos.ailauncher.task.space.MemorySettingApi.INSTANCE
            java.util.List r6 = r6.O()
            goto L46
        L23:
            java.lang.String r0 = "memo"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L2c
            goto L3b
        L2c:
            com.stepos.ailauncher.task.space.MemorySettingApi r6 = com.stepos.ailauncher.task.space.MemorySettingApi.INSTANCE
            java.util.List r6 = r6.N()
            goto L46
        L33:
            java.lang.String r0 = "communication"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L40
        L3b:
            java.util.List r6 = Z8.C1173v.m()
            goto L46
        L40:
            com.stepos.ailauncher.task.space.MemorySettingApi r6 = com.stepos.ailauncher.task.space.MemorySettingApi.INSTANCE
            java.util.List r6 = r6.M()
        L46:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r5.iterator()
        L51:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L68
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.stepos.ailauncher.task.space.h0 r3 = (com.stepos.ailauncher.task.space.MemoryItemParsed) r3
            boolean r3 = r3.getIsPersistent()
            if (r3 == 0) goto L51
            r0.add(r2)
            goto L51
        L68:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r5 = r5.iterator()
        L71:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L88
            java.lang.Object r2 = r5.next()
            r3 = r2
            com.stepos.ailauncher.task.space.h0 r3 = (com.stepos.ailauncher.task.space.MemoryItemParsed) r3
            boolean r3 = r3.getIsPersistent()
            if (r3 != 0) goto L71
            r1.add(r2)
            goto L71
        L88:
            com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$c r5 = new com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$c
            r5.<init>(r6)
            java.util.List r5 = Z8.F.c1(r0, r5)
            com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$d r6 = new com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$d
            r6.<init>()
            java.util.List r6 = Z8.F.c1(r1, r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.Context r4 = r4.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.p.h(r4, r1)
            java.util.Iterator r5 = r5.iterator()
        Lad:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lc3
            java.lang.Object r1 = r5.next()
            com.stepos.ailauncher.task.space.h0 r1 = (com.stepos.ailauncher.task.space.MemoryItemParsed) r1
            com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$a r2 = com.stepos.ailauncher.task.space.AmooMemoryDetailFragment.INSTANCE
            com.stepos.ailauncher.task.space.e0 r1 = r2.c(r1, r4)
            r0.add(r1)
            goto Lad
        Lc3:
            java.util.Iterator r5 = r6.iterator()
        Lc7:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto Ldd
            java.lang.Object r6 = r5.next()
            com.stepos.ailauncher.task.space.h0 r6 = (com.stepos.ailauncher.task.space.MemoryItemParsed) r6
            com.stepos.ailauncher.task.space.AmooMemoryDetailFragment$a r1 = com.stepos.ailauncher.task.space.AmooMemoryDetailFragment.INSTANCE
            com.stepos.ailauncher.task.space.e0 r6 = r1.c(r6, r4)
            r0.add(r6)
            goto Lc7
        Ldd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.AmooMemoryDetailFragment.X(java.util.List, java.lang.String):java.util.List");
    }

    public final void Y(String memoryId, String content) {
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        kotlin.jvm.internal.p.i(content, "content");
        C3632j0 c3632j0L = L();
        if (c3632j0L != null) {
            c3632j0L.u(memoryId, content);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.loadJob = null;
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        Q();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._binding = r6.f.a(view);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageView btnBack = K().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        ImageView btnAdd = K().btnAdd;
        kotlin.jvm.internal.p.h(btnAdd, "btnAdd");
        C2773b6.p(c2773b6, new View[]{btnBack, btnAdd}, null, false, 6, null);
        S();
        V();
        if (savedInstanceState == null) {
            K().viewPager.m(M(), false);
        }
        O();
    }
}
