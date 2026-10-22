package com.android.contacts.calllog.blocked;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.os.Bundle;
import android.security.bytedance.guard.BDSettingsEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.calllog.blocked.data.BlockedCallEntity;
import com.android.contacts.calllog.blocked.repo.BlockedDataRequester;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.SelectAllState;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.anim.ListAnimator;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIHelper;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.ICallData;
import com.obric.utils.OAutoSecurityGuardUtils;
import com.obric.utils.ObricGroupCallRecyclerViewAdapter;
import com.obric.utils.views.ObricBottomDeleteBarView;
import com.obric.widget.EmptySupportRecyclerView;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: BlockedCallActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0013\u001a\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0002OPB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0002J7\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+2!\u00101\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020)02J\b\u00107\u001a\u00020)H\u0002J\b\u00108\u001a\u00020)H\u0002J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u000203H\u0002J\u0018\u0010;\u001a\u0012\u0012\u0004\u0012\u00020=0<j\b\u0012\u0004\u0012\u00020=`>H\u0002J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u00020)H\u0002J\u0012\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\b\u0010D\u001a\u00020)H\u0014J\u0010\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020GH\u0016J\u0006\u0010H\u001a\u00020)J\u0006\u0010I\u001a\u00020)J\u0010\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020)H\u0002J\u0006\u0010N\u001a\u00020)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockedCallActivity;", "Lcom/android/contacts/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "adapter", "Lcom/android/contacts/calllog/blocked/BlockedCallAdapter;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mBottomDeleteBar", "Lcom/obric/utils/views/ObricBottomDeleteBarView;", "mBottomDeleteBarBtn", "Lcom/obric/oui/button/OButtonFloating;", "mBottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "mCallAnimator", "Lcom/obric/anim/ListAnimator;", "mDataChangeListener", "com/android/contacts/calllog/blocked/BlockedCallActivity$mDataChangeListener$1", "Lcom/android/contacts/calllog/blocked/BlockedCallActivity$mDataChangeListener$1;", "mDeleteConfirmDialog", "Lcom/obric/oui/selection/OActionSheet;", "mLongMenuHelper", "Lcom/obricOld/contacts/menus/LongMenuHelper;", "mLongMenuHelperListener", "com/android/contacts/calllog/blocked/BlockedCallActivity$mLongMenuHelperListener$1", "Lcom/android/contacts/calllog/blocked/BlockedCallActivity$mLongMenuHelperListener$1;", "mLongMenuItems", "", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "[Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "mMenuPopover", "Lcom/obric/oui/popover/v2/OPopover;", "mOTitleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "mSelectedAllState", "Lcom/android/contacts/widget/SelectAllState;", "recyclerView", "Lcom/obric/widget/EmptySupportRecyclerView;", "clickBottomDeleteBar", "", "collectIdGroups", "", "", "data", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "deleteBlockedCalls", "idGroups", "onDeleteDone", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "doRemoveAction", "endEditAnimation", "endEditMode", "withAnimation", "getMenuItems", "Ljava/util/ArrayList;", "Lcom/obric/ui/popover/MenuItemData;", "Lkotlin/collections/ArrayList;", "isEditMode", "onClickSelectedAll", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStatusBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "refreshUI", "showDeleteConfirmDialog", "showMenu", "anchor", "Landroid/view/View;", "startEditAnimation", "startEditMode", "Companion", "MenuData", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedCallActivity extends BaseActivity implements CoroutineScope {
    private static final Companion Companion = null;
    private static final String TAG = "BlockedCallActivity";
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final BlockedCallAdapter adapter;
    private ObricBottomDeleteBarView mBottomDeleteBar;
    private OButtonFloating mBottomDeleteBarBtn;
    private final BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private final ListAnimator mCallAnimator;
    private final BlockedCallActivity$mDataChangeListener$1 mDataChangeListener;
    private OActionSheet mDeleteConfirmDialog;
    private LongMenuHelper mLongMenuHelper;
    private final BlockedCallActivity$mLongMenuHelperListener$1 mLongMenuHelperListener;
    private final LongMenuHelper.MenuType[] mLongMenuItems;
    private OPopover mMenuPopover;
    private OFloatingTitleBarHolder mOTitleBarHolder;
    private SelectAllState mSelectedAllState;
    private EmptySupportRecyclerView recyclerView;

    /* JADX INFO: compiled from: BlockedCallActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockedCallActivity$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: BlockedCallActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockedCallActivity$MenuData;", "", "data", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "Lcom/android/contacts/calllog/blocked/data/BlockedCallEntity;", "position", "", "(Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;I)V", "getData", "()Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MenuData {
        private final ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> data;
        private final int position;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MenuData copy$default(MenuData r0, ObricGroupCallRecyclerViewAdapter.GroupCallData r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.position;
        L9:
            return r0.copy(r1, r2);
        }

        public final ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> component1() {
            return this.data;
        }

        public final int component2() {
            return this.position;
        }

        public final MenuData copy(ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "data");
            return new MenuData(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof MenuData) == true) goto L8;
            return false;
        L8:
            MenuData r6 = (MenuData) r5;
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L12;
            return false;
        L12:
            if (this.position == r6.position) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + Integer.hashCode(this.position);
        }

        public String toString() {
            return "MenuData(data=" + this.data + ", position=" + this.position + ')';
        }

        public MenuData(ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.data = r2;
            this.position = r3;
        }

        public final ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> getData() {
            return this.data;
        }

        public final int getPosition() {
            return this.position;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.BlockedCallActivity$deleteBlockedCalls$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlockedCallActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.BlockedCallActivity$deleteBlockedCalls$1", f = "BlockedCallActivity.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<Long> $idGroups;
        final /* synthetic */ Function1<Boolean, Unit> $onDeleteDone;
        int label;
        final /* synthetic */ BlockedCallActivity this$0;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(BlockedCallActivity r1, Set<Long> r2, Function1<? super Boolean, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$idGroups = r2;
            this.$onDeleteDone = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$idGroups, this.$onDeleteDone, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            int r7 = ((Number) r6).intValue();
            Function1<Boolean, Unit> r5 = this.$onDeleteDone;
            if (r7 > 0) goto L15;
            r2 = false;
        L15:
            r5.invoke(Boxing.boxBoolean(r2));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            BlockedDataRequester r8 = BlockedDataRequester.INSTANCE;
            ContentResolver r3 = this.this$0.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(r3, "contentResolver");
            this.label = 1;
            r6 = r8.deleteBlockedCallAsync(r3, this.$idGroups, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1uFksPx3YlBB-itSEW687Gik9jM, reason: not valid java name */
    public static /* synthetic */ void m131$r8$lambda$1uFksPx3YlBBitSEW687Gik9jM(BlockedCallActivity r0, View r1) {
        onCreate$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$C03CMMFb0VPLw7UN4BBYdjhosns(BlockedCallActivity r0, View r1) {
        onCreate$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GPO5LHUrUVfaYQco9MFdzGKBDW0(BlockedCallActivity r0, View r1) {
        onCreate$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$i01V83xRj72Bjq75GL4R1rT_gxo(BlockedCallActivity r0, int r1, View r2) {
        showDeleteConfirmDialog$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$n33KNUV_a59YgGMAzWCMHPwGUL8(BlockedCallActivity r0, View r1) {
        onCreate$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vCGkB8I-vKBMtN0SjFkm670n1OE, reason: not valid java name */
    public static /* synthetic */ void m132$r8$lambda$vCGkB8IvKBMtN0SjFkm670n1OE(BlockedCallActivity r0, int r1, DialogInterface r2) {
        showDeleteConfirmDialog$lambda$12(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$wfBzA8bUPZ1pHOQ5cNfdp-rc6Q8, reason: not valid java name */
    public static /* synthetic */ void m133$r8$lambda$wfBzA8bUPZ1pHOQ5cNfdprc6Q8(BlockedCallActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_contacts_calllog_blocked_BlockedCallActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_calllog_blocked_BlockedCallActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_calllog_blocked_BlockedCallActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_calllog_blocked_BlockedCallActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.android.contacts.calllog.blocked.BlockedCallActivity$mLongMenuHelperListener$1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.android.contacts.calllog.blocked.BlockedCallActivity$mDataChangeListener$1] */
    public BlockedCallActivity() {
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.mLongMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_DELETE};
        this.adapter = new BlockedCallAdapter(this, new BlockedCallActivity$adapter$1(this));
        this.mLongMenuHelperListener = new BlockedCallActivity$mLongMenuHelperListener$1(this);
        this.mDataChangeListener = new BlockedCallActivity$mDataChangeListener$1(this);
        this.mCallAnimator = new ListAnimator(new int[]{R.id.title_container}, null, new int[]{R.id.custom_start_container}, 2, null);
        this.mBottomDeleteLayoutListener = new BlockedCallActivity$mBottomDeleteLayoutListener$1(this);
    }

    public static final /* synthetic */ Set access$collectIdGroups(BlockedCallActivity r0, ObricGroupCallRecyclerViewAdapter.GroupCallData r1) {
        return r0.collectIdGroups(r1);
    }

    public static final /* synthetic */ void access$endEditMode(BlockedCallActivity r0, boolean r1) {
        r0.endEditMode(r1);
    }

    public static final /* synthetic */ BlockedCallAdapter access$getAdapter$p(BlockedCallActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ ObricBottomDeleteBarView access$getMBottomDeleteBar$p(BlockedCallActivity r0) {
        return r0.mBottomDeleteBar;
    }

    public static final /* synthetic */ OButtonFloating access$getMBottomDeleteBarBtn$p(BlockedCallActivity r0) {
        return r0.mBottomDeleteBarBtn;
    }

    public static final /* synthetic */ OActionSheet access$getMDeleteConfirmDialog$p(BlockedCallActivity r0) {
        return r0.mDeleteConfirmDialog;
    }

    public static final /* synthetic */ LongMenuHelper access$getMLongMenuHelper$p(BlockedCallActivity r0) {
        return r0.mLongMenuHelper;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getMLongMenuItems$p(BlockedCallActivity r0) {
        return r0.mLongMenuItems;
    }

    public static final /* synthetic */ OPopover access$getMMenuPopover$p(BlockedCallActivity r0) {
        return r0.mMenuPopover;
    }

    public void com_android_contacts_calllog_blocked_BlockedCallActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.activity_blocked_call_layout);
        BlockedCallActivity r7 = this;
        UiUtils.setWindowColorStatusBar(r7);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r0 != null) goto L5;
        return;
    L5:
        OFloatingTitleBarHolder r1 = new OFloatingTitleBarHolder(r0);
        this.mOTitleBarHolder = r1;
        r1.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_back_22_22, new BlockedCallActivity$$ExternalSyntheticLambda0(this));
        OFloatingTitleBarHolder r2 = this.mOTitleBarHolder;
        if (r2 == null) goto L8;
        r2.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_menu_more, new BlockedCallActivity$$ExternalSyntheticLambda1(this));
    L8:
        OFloatingTitleBarHolder r3 = this.mOTitleBarHolder;
        if (r3 == null) goto L11;
        r3.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new BlockedCallActivity$$ExternalSyntheticLambda2(this));
    L11:
        OFloatingTitleBarHolder r4 = this.mOTitleBarHolder;
        if (r4 == null) goto L14;
        r4.removeStartAction();
    L14:
        OFloatingTitleBarHolder r5 = this.mOTitleBarHolder;
        if (r5 == null) goto L17;
        String r8 = getResources().getString(R.string.select_all);
        Intrinsics.checkNotNullExpressionValue(r8, "resources.getString(R.string.select_all)");
        View r9 = r5.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, r8, new BlockedCallActivity$$ExternalSyntheticLambda3(this));
    L19:
        if ((r9 instanceof ViewGroup) == false) goto L21;
        ViewGroup r10 = (ViewGroup) r9;
    L22:
        if (r10 == null) goto L24;
        View r11 = r10.getChildAt(0);
    L26:
        if ((r11 instanceof OTextView) == false) goto L28;
        OTextView r12 = (OTextView) r11;
    L29:
        if (r12 == null) goto L31;
        r12.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        this.mSelectedAllState = new SelectAllState(r12);
    L31:
        OFloatingTitleBarHolder r13 = this.mOTitleBarHolder;
        if (r13 == null) goto L34;
        r13.removeEndAction();
    L34:
        ObricBottomDeleteBarView r14 = (ObricBottomDeleteBarView) findViewById(R.id.bottom_delete_bar);
        this.mBottomDeleteBar = r14;
        if (r14 == null) goto L37;
        OButtonFloating r15 = r14.getDeleteBtn();
    L38:
        this.mBottomDeleteBarBtn = r15;
        if (r15 == null) goto L41;
        r15.setOnClickListener(new BlockedCallActivity$$ExternalSyntheticLambda4(this));
    L41:
        View r16 = findViewById(R.id.list);
        Intrinsics.checkNotNull(r16);
        EmptySupportRecyclerView r17 = (EmptySupportRecyclerView) r16;
        this.recyclerView = r17;
        if (r17 == null) goto L53;
        View r18 = findViewById(R.id.list_empty_view);
        if (r18 == null) goto L51;
        OPageStatus r19 = (OPageStatus) r18.findViewById(R.id.black_view);
        if (r19 == null) goto L49;
        r19.setTitle(getString(R.string.no_blocked_call_log));
    L49:
        if (r19 == null) goto L52;
        r19.setMessage(getString(R.string.no_blocked_call_log_desc));
    L52:
        r17.setEmptyView(r18);
        goto L53
    L51:
        r18 = null;
    L53:
        this.adapter.setOnDataChangeListener(this.mDataChangeListener);
        int r20 = OUIHelper.OUIList.getHeaderHeight96();
        this.adapter.addHeader(new ObricGroupCallRecyclerViewAdapter.HeaderFooterData(r20));
        this.adapter.addFooter(new ObricGroupCallRecyclerViewAdapter.HeaderFooterData(r20));
        EmptySupportRecyclerView r21 = this.recyclerView;
        if (r21 == null) goto L57;
        r21.setLayoutManager(new LinearLayoutManager(this));
    L57:
        EmptySupportRecyclerView r22 = this.recyclerView;
        if (r22 == null) goto L61;
        r22.setAdapter(this.adapter);
    L61:
        ObricGroupCallRecyclerViewAdapter.startQuery$default(this.adapter, null, 1, null);
        this.mLongMenuHelper = new LongMenuHelper(r7, this.mLongMenuHelperListener);
        return;
    L37:
        r15 = null;
        goto L38
    L28:
        r12 = null;
        goto L29
    L24:
        r11 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r9 = null;
        goto L19
    }

    private static final void onCreate$lambda$0(BlockedCallActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void onCreate$lambda$1(BlockedCallActivity r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.showMenu(r2);
    }

    private static final void onCreate$lambda$2(BlockedCallActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.isEditMode() == false) goto L6;
        r0.endEditMode(true);
        return;
    }

    private static final void onCreate$lambda$3(BlockedCallActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClickSelectedAll();
    }

    private static final void onCreate$lambda$5(BlockedCallActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.clickBottomDeleteBar();
    }

    public void com_android_contacts_calllog_blocked_BlockedCallActivity__onDestroy$___twin___() {
        OPopover r0 = this.mMenuPopover;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        super.onDestroy();
        this.adapter.destroy();
    }

    private final void clickBottomDeleteBar() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "clickBottomDeleteBar");
        showDeleteConfirmDialog();
    }

    private final void onClickSelectedAll() {
        SelectAllState r0 = this.mSelectedAllState;
        if (r0 == null) goto L5;
        r0.toggle();
    L5:
        SelectAllState r1 = this.mSelectedAllState;
        if (r1 == null) goto L8;
        boolean r2 = r1.isSelectAll();
    L9:
        this.adapter.setCheckedAll(r2);
        refreshUI();
        this.adapter.notifyDataSetChanged();
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(r2);
        return;
    L8:
        r2 = false;
        goto L9
    }

    private final void showMenu(View r6) {
        OPopover r0 = this.mMenuPopover;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        BlockedCallActivity r1 = this;
        OPopover r2 = OUIPopoverHelper.genPopover$default(r1, getMenuItems(), false, 4, null);
        this.mMenuPopover = r2;
        if (r2 == null) goto L9;
        OUIPopoverHelper.showPopupAtAnchorView(r1, r2, Direct.BOTTOM_LEFT, r6, null);
        return;
    }

    private final ArrayList<MenuItemData> getMenuItems() {
        ArrayList<MenuItemData> r1 = new ArrayList();
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_item_settings_icon), null, null, getString(R.string.blocked_call_settings_title), null, null, null, null, new C01461(this), false, 1024, null));
        if (this.adapter.getRealDataItemCount() <= 0) goto L5;
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_item_multi_select_icon), null, null, getString(R.string.btn_select), null, null, null, null, new C01472(this), false, 1024, null));
    L5:
        return r1;
    }

    private final boolean isEditMode() {
        return this.adapter.isEditMode();
    }

    public final void startEditMode() {
        if (this.adapter.isEditMode() == true) goto L13;
        this.adapter.setEditMode(true);
        SelectAllState r0 = this.mSelectedAllState;
        if (r0 == null) goto L8;
        r0.setSelectAll(false);
    L8:
        OFloatingTitleBarHolder r1 = this.mOTitleBarHolder;
        if (r1 == null) goto L11;
        r1.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L11:
        startEditAnimation();
        this.mBottomDeleteLayoutListener.startTransition(true);
        refreshUI();
        return;
    }

    private final void startEditAnimation() {
        EmptySupportRecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L5;
        this.mCallAnimator.startEdit(r0);
    L5:
        this.adapter.notifyDataSetChanged();
    }

    private final void endEditAnimation() {
        EmptySupportRecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L5;
        this.mCallAnimator.finishEdit(r0);
    L5:
        this.adapter.notifyDataSetChanged();
    }

    private final void endEditMode(boolean r4) {
        if (this.adapter.isEditMode() == true) goto L5;
        return;
    L5:
        this.adapter.setEditMode(false);
        OFloatingTitleBarHolder r0 = this.mOTitleBarHolder;
        if (r0 == null) goto L8;
        r0.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
    L8:
        this.adapter.clearCheckedState();
        if (r4 == false) goto L11;
        endEditAnimation();
        this.mBottomDeleteLayoutListener.startTransition(false);
    L12:
        refreshUI();
        return;
    L11:
        this.adapter.notifyDataSetChanged();
        goto L12
    }

    public final void refreshUI() {
        boolean r1 = false;
        if (this.adapter.isEditMode() == false) goto L21;
        int r0 = this.adapter.getCheckedMap().size();
        if (r0 <= 0) goto L7;
        boolean r3 = true;
    L8:
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(r3);
        OFloatingTitleBarHolder r4 = this.mOTitleBarHolder;
        if (r4 == null) goto L13;
        OFloatingTitleBar r5 = r4.getTitleBar();
        if (r5 == null) goto L13;
        r5.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r0)}));
    L13:
        int r6 = this.adapter.getRealDataItemCount();
        if (r6 <= 0) goto L17;
        if (r0 != r6) goto L17;
        r1 = true;
    L17:
        SelectAllState r7 = this.mSelectedAllState;
        if (r7 == null) goto L32;
        r7.setSelectAll(r1);
        return;
    L32:
        return;
    L7:
        r3 = false;
        goto L8
    L21:
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        OFloatingTitleBarHolder r2 = this.mOTitleBarHolder;
        if (r2 == null) goto L26;
        OFloatingTitleBar r8 = r2.getTitleBar();
        if (r8 == null) goto L26;
        r8.setCenterTitle(getString(R.string.blocked_call_log_title));
    L26:
        SelectAllState r9 = this.mSelectedAllState;
        if (r9 == null) goto L33;
        r9.setSelectAll(false);
        return;
    }

    public final void showDeleteConfirmDialog() {
        String r3 = getString(R.string.dialog_title_delete_call_log_no_record);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(titleId)");
        final int r0 = BDSettingsEvent.EVENT_TYPE_CALL_LOGS_DELETE.getType();
        BlockedCallActivity r9 = this;
        OInsetSheet.PanelWidth r2 = OInsetSheet.PanelWidth.NARROW_WIDTH;
        String r5 = getString(R.string.btn_confirm_delete);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.btn_confirm_delete)");
        OActionSheet r1 = OSheetUtils.getActionSheet(r9, r2, r3, null, r5, OSheetUtils.ContentViewStyle.RED, new BlockedCallActivity$$ExternalSyntheticLambda5(this, r0), new C01482(this, r0));
        this.mDeleteConfirmDialog = r1;
        if (r1 == null) goto L5;
        r1.setOnCancelListener(new BlockedCallActivity$$ExternalSyntheticLambda6(this, r0));
    L5:
        OActionSheet r10 = this.mDeleteConfirmDialog;
        if (r10 == null) goto L8;
        r10.show();
    L8:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r9, r0, true, false);
    }

    private static final void showDeleteConfirmDialog$lambda$11(BlockedCallActivity r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.doRemoveAction();
        OActionSheet r4 = r1.mDeleteConfirmDialog;
        if (r4 == null) goto L5;
        r4.dismiss();
    L5:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r1, r2, false, true);
    }

    private static final void showDeleteConfirmDialog$lambda$12(BlockedCallActivity r0, int r1, DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r0, r1, false, false);
    }

    private final void doRemoveAction() {
        Map<Integer, ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> r0 = this.adapter.getCheckedMap();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r2 = r0.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L24;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (((ObricGroupCallRecyclerViewAdapter.GroupCallData) r3.getValue()).getGroupCount() > 1) goto L10;
        r1.add(Long.valueOf(((BlockedCallEntity) ((ObricGroupCallRecyclerViewAdapter.GroupCallData) r3.getValue()).getData()).getCallId()));
        goto L7
    L10:
        LinkedHashSet<Long> r4 = ((ObricGroupCallRecyclerViewAdapter.GroupCallData) r3.getValue()).getIdGroup();
        LinkedHashSet<Long> r5 = r4;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L18:
        if ((!r6) == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L7;
        r1.addAll(r4);
        goto L7
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
        goto L18
    L24:
        deleteBlockedCalls(r1, new AnonymousClass2(this));
    }

    private final Set<Long> collectIdGroups(ObricGroupCallRecyclerViewAdapter.GroupCallData<?> r4) {
        LinkedHashSet r3 = new LinkedHashSet();
        ICallData r1 = null;
        LinkedHashSet<Long> r2 = null;
        if (r4.getGroupCount() <= 1) goto L16;
        LinkedHashSet<Long> r5 = r4.getIdGroup();
        LinkedHashSet<Long> r0 = r5;
        if (r0 != null) goto L7;
    L10:
        boolean r6 = true;
    L12:
        if ((!r6) == false) goto L14;
        r2 = r5;
    L14:
        if (r2 == null) goto L22;
        r3.addAll(r2);
    L22:
        return r3;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r6 = false;
        goto L12
    L16:
        Object r7 = r4.getData();
        if ((r7 instanceof ICallData) == false) goto L19;
        r1 = (ICallData) r7;
    L19:
        if (r1 == null) goto L22;
        r3.add(Long.valueOf(r1.getCallId()));
        goto L22
    }

    public final void deleteBlockedCalls(Set<Long> r8, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "idGroups");
        Intrinsics.checkNotNullParameter(r9, "onDeleteDone");
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_calllog_blocked_BlockedCallActivity_com_obric_privacyhook_PrivacyHook_onCreate(BlockedCallActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BlockedCallActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_calllog_blocked_BlockedCallActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_calllog_blocked_BlockedCallActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BlockedCallActivity r1) {
        com_android_contacts_calllog_blocked_BlockedCallActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_calllog_blocked_BlockedCallActivity_com_obric_privacyhook_PrivacyHook_onStop(BlockedCallActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BlockedCallActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_calllog_blocked_BlockedCallActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_calllog_blocked_BlockedCallActivity_com_obric_privacyhook_PrivacyHook_onDestroy(BlockedCallActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BlockedCallActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_calllog_blocked_BlockedCallActivity__onDestroy$___twin___();
    }
}
