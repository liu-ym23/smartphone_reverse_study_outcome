package com.android.contacts.calllog.v2;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.GlobalProxyLancet;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactDetailActivity;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.IntentProvider;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.toast.OToast;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.utils.ClipboardReader;
import com.obric.utils.views.commonitemview.CallLogItemView;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import com.obricOld.contacts.menus.LongMenuHelper;
import com.ss.android.http.legacy.protocol.HTTP;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CallLogItemActionHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\r0\u000f\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0011J&\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J$\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010(\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\u0012R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogItemActionHelper;", "", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/android/contacts/calllog/v2/CallLogViewModel;", "contactInfoCache", "Lkotlin/Function0;", "Lcom/android/contacts/calllog/v2/ContactInfoCache;", "onMarkNumber", "Lkotlin/Function2;", "", "", "", "onUnMarkNumber", "Lkotlin/Function1;", "onAnimateSwipeDelete", "Lcom/android/contacts/calllog/v2/CallLogItem;", "Landroid/view/View;", "(Landroidx/fragment/app/Fragment;Lcom/android/contacts/calllog/v2/CallLogViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "longMenuHelper", "Lcom/obricOld/contacts/menus/LongMenuHelper;", "longPressedItemView", "Lcom/obric/utils/views/commonitemview/CallLogItemView;", "destroy", "dismissMenu", "init", "isStranger", "item", "onDetailClick", "onItemClick", "onItemLongClick", "view", MaterialConfigFormatNames.X, "", MaterialConfigFormatNames.Y, "onLongMenuItemClicked", "menuType", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "data", "onSwipeAction", "type", "Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogItemActionHelper {
    public static final Companion Companion = null;
    private static final LongMenuHelper.MenuType[] LONG_MENU_ITEMS_CONTACTS = null;
    private static final LongMenuHelper.MenuType[] LONG_MENU_ITEMS_SINGLE = null;
    private static final LongMenuHelper.MenuType[] LONG_MENU_ITEMS_STRANGER = null;
    private static final String TAG = "CallLogV2";
    private final Function0<ContactInfoCache> contactInfoCache;
    private final Fragment fragment;
    private LongMenuHelper longMenuHelper;
    private CallLogItemView longPressedItemView;
    private final Function2<CallLogItem, View, Unit> onAnimateSwipeDelete;
    private final Function2<String, Boolean, Unit> onMarkNumber;
    private final Function1<String, Unit> onUnMarkNumber;
    private final CallLogViewModel viewModel;

    /* JADX INFO: compiled from: CallLogItemActionHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogItemActionHelper$Companion;", "", "()V", "LONG_MENU_ITEMS_CONTACTS", "", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "[Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "LONG_MENU_ITEMS_SINGLE", "LONG_MENU_ITEMS_STRANGER", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CallLogItemActionHelper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[SwipeItemButtonType.values().length];
            r0[SwipeItemButtonType.SWIPE_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SwipeItemButtonType.SWIPE_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[LongMenuHelper.MenuType.values().length];
            r1[LongMenuHelper.MenuType.MENU_COPY_NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L37:
            r1[LongMenuHelper.MenuType.MENU_MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L29:
            r1[LongMenuHelper.MenuType.MENU_DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r1[LongMenuHelper.MenuType.MENU_CREATE_CONTACTS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L23:
            r1[LongMenuHelper.MenuType.MENU_BLACK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L33:
            r1[LongMenuHelper.MenuType.MENU_FLAG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L13:
            $EnumSwitchMapping$1 = r1;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogItemActionHelper$onDetailClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogItemActionHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogItemActionHelper$onDetailClick$2", f = "CallLogItemActionHelper.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $act;
        final /* synthetic */ Context $ctx;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ Uri $lookupUri;
        int label;
        final /* synthetic */ CallLogItemActionHelper this$0;

        /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogItemActionHelper$onDetailClick$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CallLogItemActionHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogItemActionHelper$onDetailClick$2$2", f = "CallLogItemActionHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FragmentActivity $act;
            final /* synthetic */ Context $ctx;
            final /* synthetic */ Intent $intent;
            final /* synthetic */ Uri $lookupUri;
            int label;
            final /* synthetic */ CallLogItemActionHelper this$0;

            C00182(CallLogItemActionHelper r1, Uri r2, Intent r3, Context r4, FragmentActivity r5, Continuation<? super C00182> r6) {
                this.this$0 = r1;
                this.$lookupUri = r2;
                this.$intent = r3;
                this.$ctx = r4;
                this.$act = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new C00182(this.this$0, this.$lookupUri, this.$intent, this.$ctx, this.$act, r9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00182) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r3);
                if (CallLogItemActionHelper.access$getFragment$p(this.this$0).isAdded() == false) goto L7;
                ContactDetailCacheManager.getInstance().loadResultData(this.$lookupUri);
                this.$intent.putExtra(ContactDetailActivity.EXTRA_LAUNCH_FROM_SELF, true);
                this.$ctx.startActivity(this.$intent);
                AnimationUtil.switchActivityAnimation(this.$act, 5);
                return Unit.INSTANCE;
            L7:
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(Uri r1, Context r2, Intent r3, CallLogItemActionHelper r4, FragmentActivity r5, Continuation<? super AnonymousClass2> r6) {
            this.$lookupUri = r1;
            this.$ctx = r2;
            this.$intent = r3;
            this.this$0 = r4;
            this.$act = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass2(this.$lookupUri, this.$ctx, this.$intent, this.this$0, this.$act, r9);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L30:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            if (this.$lookupUri != null) goto L33;
        L26:
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00182(this.this$0, this.$lookupUri, this.$intent, this.$ctx, this.$act, null), this) != r0) goto L30;
            return r0;
        L33:
            Cursor r12 = this.$ctx.getContentResolver().query(this.$lookupUri, new String[]{"_id"}, null, null, null);     // Catch: Exception -> L24
            if (r12 == null) goto L26;
            Cursor r13 = r12;     // Catch: Exception -> L24
            Intent r2 = this.$intent;     // Catch: Exception -> L24
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L24
            throw th;     // Catch: Exception -> L24
        L14:
            if (r13.getCount() != 0) goto L16;
            r2.setData(null);     // Catch: Throwable -> L19
        L16:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
            CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L24
            goto L26
        L24:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallLogItemActionHelper.TAG, "onDetailClick: query lookupUri failed", e);
            goto L26
        }
    }

    public static /* synthetic */ boolean $r8$lambda$r9VUpkuJ_iolPzfF7t0a06wViAs(CallLogItemActionHelper r0, LongMenuHelper.MenuType r1, View r2, Object r3) {
        return r0.onLongMenuItemClicked(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallLogItemActionHelper(Fragment r2, CallLogViewModel r3, Function0<ContactInfoCache> r4, Function2<? super String, ? super Boolean, Unit> r5, Function1<? super String, Unit> r6, Function2<? super CallLogItem, ? super View, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "contactInfoCache");
        Intrinsics.checkNotNullParameter(r5, "onMarkNumber");
        Intrinsics.checkNotNullParameter(r6, "onUnMarkNumber");
        Intrinsics.checkNotNullParameter(r7, "onAnimateSwipeDelete");
        this.fragment = r2;
        this.viewModel = r3;
        this.contactInfoCache = r4;
        this.onMarkNumber = r5;
        this.onUnMarkNumber = r6;
        this.onAnimateSwipeDelete = r7;
    }

    public static final /* synthetic */ Fragment access$getFragment$p(CallLogItemActionHelper r0) {
        return r0.fragment;
    }

    public final void init() {
        this.longMenuHelper = new LongMenuHelper(this.fragment.getActivity(), new CallLogItemActionHelper$$ExternalSyntheticLambda0(this));
    }

    public final void onItemClick(CallLogItem r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        if (this.fragment.isAdded() == true) goto L6;
        return;
    L6:
        if (this.viewModel.getUiState().getValue().getEditMode().isActive() == false) goto L10;
        this.viewModel.toggleGroupSelection(r9.getChildIds());
        return;
    L10:
        if (ContactsUtils.isJustClicked() == false) goto L12;
        return;
    L12:
        Context r1 = this.fragment.getContext();
        if (r1 != null) goto L15;
        return;
    L15:
        boolean r5 = isStranger(r9);
        if (r9.getFeatures() != 1) goto L18;
        boolean r8 = true;
    L20:
        if (r9.getCallType() != 4) goto L23;
        IntentProvider r10 = IntentProvider.getPlayVoicemailIntentProvider(r9.getId(), r9.getVoicemailUri());
        Intrinsics.checkNotNullExpressionValue(r10, "{\n                Intent…icemailUri)\n            }");
    L29:
        if (DSUtils.isSimManualSelectMode() == true) goto L31;
    L37:
        r1.startActivity(r10.getIntent(r1));
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        return;
    L31:
        if (r9.getCallType() == 4) goto L37;
        if (r10.getIntent(r1).getIntExtra(Constants.EXTRA_START_CALL_WITH_VIDEO_STATE, -1) != 3) goto L35;
        boolean r6 = true;
    L36:
        ContactsUtils.showSelectSimDialog(r1, r9.getContactName(), r9.getNumber(), 1, r5, r6);
        return;
    L35:
        r6 = false;
        goto L36
    L23:
        if (DSUtils.useDSFeature() == false) goto L25;
        r10 = IntentProvider.getReturnCallIntentProvider(r9.getNumber(), r9.getSubscription(), r9.getSimId(), r5, r8);
        Intrinsics.checkNotNullExpressionValue(r10, "{\n                Intent…sVideoCall)\n            }");
        goto L29
    L25:
        if (r8 == false) goto L27;
        r10 = IntentProvider.getReturnVideoCallIntentProvider(r9.getNumber());
        Intrinsics.checkNotNullExpressionValue(r10, "{\n                Intent…tem.number)\n            }");
        goto L29
    L27:
        r10 = IntentProvider.getReturnCallIntentProvider(r9.getNumber(), r5);
        Intrinsics.checkNotNullExpressionValue(r10, "{\n                Intent…isStranger)\n            }");
        goto L29
    L18:
        r8 = false;
        goto L20
    }

    public final void onItemLongClick(CallLogItem r9, View r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "view");
        if (this.fragment.isAdded() == true) goto L6;
        return;
    L6:
        if (this.viewModel.getUiState().getValue().getEditMode().isActive() == false) goto L8;
        return;
    L8:
        if ((r10 instanceof CallLogItemView) == false) goto L10;
        CallLogItemView r0 = (CallLogItemView) r10;
    L11:
        this.longPressedItemView = r0;
        if (this.viewModel.isSingleContactMode() == false) goto L16;
        LongMenuHelper.MenuType[] r1 = LONG_MENU_ITEMS_SINGLE;
    L14:
        LongMenuHelper.MenuType[] r7 = r1;
        LongMenuHelper r2 = this.longMenuHelper;
        if (r2 == null) goto L22;
        r2.setMenuItemDatas(r10, R.id.item_foreground, r9, r11, r12, r7);
    L22:
        LongMenuHelper r8 = this.longMenuHelper;
        if (r8 == null) goto L25;
        r8.show();
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onItemLongClick: show context menu");
        return;
    L16:
        if (isStranger(r9) == false) goto L18;
        r1 = LONG_MENU_ITEMS_STRANGER;
        goto L14
    L18:
        r1 = LONG_MENU_ITEMS_CONTACTS;
        goto L14
    L10:
        r0 = null;
        goto L11
    }

    public final void onDetailClick(CallLogItem r14) {
        Intrinsics.checkNotNullParameter(r14, "item");
        if (this.fragment.isAdded() == true) goto L6;
        return;
    L6:
        if (this.viewModel.getUiState().getValue().getEditMode().isActive() == false) goto L8;
        return;
    L8:
        Context r3 = this.fragment.getContext();
        if (r3 != null) goto L11;
        return;
    L11:
        FragmentActivity r6 = this.fragment.getActivity();
        if (r6 != null) goto L14;
        return;
    L14:
        ContactInfoCache r0 = this.contactInfoCache.invoke();
        if (r0 == null) goto L17;
        ContactInfo r1 = r0.get(r14.getNumber(), r14.getCountryIso());
    L18:
        if (r1 == null) goto L20;
        Uri r2 = r1.lookupUri;
    L21:
        Uri r4 = r2;
        Intent r5 = new Intent(r3, ContactDetailActivity.class);
        String r7 = r14.getVoicemailUri();
        if (r7 == null) goto L24;
        r5.putExtra(CallDetailActivity.EXTRA_VOICEMAIL_URI, Uri.parse(r7));
    L24:
        r5.putExtra(CallDetailActivity.EXTRA_VOICEMAIL_START_PLAYBACK, false);
        r5.setAction("android.intent.action.VIEW");
        if (r4 == null) goto L27;
        r5.setData(r4);
    L27:
        r5.putExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS, CollectionsKt.toLongArray(r14.getChildIds()));
        r5.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r14.getNumber());
        r5.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS_PRESENTATION, r14.getPresentation());
        String r8 = r14.getCountryIso();
        String r9 = "";
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        r5.putExtra(ContactsUtils.EXTRA_COUNTRY_ISO, r8);
        String r15 = r14.getNumberLabel();
        if (r15 == null) goto L34;
        r9 = r15;
    L34:
        r5.putExtra(ContactsUtils.EXTRA_LABEL, r9);
        r5.putExtra("enter_from", "call_log_list");
        LifecycleOwner r16 = this.fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r16, "fragment.viewLifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r16), Dispatchers.getIO(), null, new AnonymousClass2(r4, r3, r5, this, r6, null), 2, null);
        return;
    L20:
        r2 = r14.getCachedLookupUri();
        goto L21
    L17:
        r1 = null;
        goto L18
    }

    public final void onSwipeAction(CallLogItem r3, SwipeItemButtonType r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "view");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        boolean r0 = true;
        if (r6 != 1) goto L5;
        AnimationUtil.startActivity(this.fragment.requireContext(), ContactsIntentUtils.getSendMessageIntent(r3.getNumber()));
        if (ContactsUtils.USER_LOG_ON == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onSwipeAction: send message to " + r3.getNumber());
        return;
    L11:
        StringBuilder r2 = new StringBuilder("onSwipeAction: send message, hasNumber=");
        if (r3.getNumber().length() > 0) goto L15;
        r0 = false;
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r2.append(r0).toString());
        return;
    L5:
        if (r6 != 2) goto L19;
        this.onAnimateSwipeDelete.invoke(r3, r5);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onSwipeAction: animate delete " + r3.getChildIds().size() + " records");
        return;
    }

    private final boolean isStranger(CallLogItem r3) {
        ContactInfoCache r2 = this.contactInfoCache.invoke();
        if (r2 == null) goto L5;
        ContactInfo r4 = r2.get(r3.getNumber(), r3.getCountryIso());
    L7:
        if (r4 == null) goto L12;
        if (r4.lookupUri != null) goto L15;
        return true;
    L15:
        return false;
    L12:
        if (r3.getCachedLookupUri() != null) goto L15;
        return true;
    L5:
        r4 = null;
        goto L7
    }

    private final boolean onLongMenuItemClicked(LongMenuHelper.MenuType r11, View r12, Object r13) {
        String r0 = null;
        if ((r13 instanceof CallLogItem) == false) goto L5;
        CallLogItem r14 = (CallLogItem) r13;
    L7:
        if (r14 != null) goto L10;
        return false;
    L10:
        switch(WhenMappings.$EnumSwitchMapping$1[r11.ordinal()]) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L17;
            case 6: goto L13;
            default: goto L11;
        };
    L11:
        return false;
    L17:
        String r15 = r14.getNumber();
        if (r15 == null) goto L21;
        r0 = StringsKt.trim(r15).toString();
    L21:
        if (TextUtils.isEmpty(r0) == false) goto L25;
        OToast.Companion r4 = OToast.Companion;
        FragmentActivity r16 = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(r16, "fragment.requireActivity()");
        String r6 = this.fragment.getString(R.string.toast_no_support_blacklist);
        Intrinsics.checkNotNullExpressionValue(r6, "fragment.getString(R.str…ast_no_support_blacklist)");
        OToast.Companion.show$default(r4, r16, r6, 0, 4, null);
        return true;
    L25:
        if (r11.isHighLight == false) goto L27;
        new BlackListQueryHandler(this.fragment.requireContext()).doRemoveBlacklistAction(r15);
        OToast.Companion r5 = OToast.Companion;
        FragmentActivity r17 = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(r17, "fragment.requireActivity()");
        String r7 = this.fragment.getString(R.string.toast_remove_blacklist_done);
        Intrinsics.checkNotNullExpressionValue(r7, "fragment.getString(R.str…st_remove_blacklist_done)");
        OToast.Companion.show$default(r5, r17, r7, 0, 4, null);
    L30:
        return true;
    L27:
        new BlackListQueryHandler(this.fragment.requireContext()).doJoinBlacklistAction(r15);
        OToast.Companion r8 = OToast.Companion;
        FragmentActivity r18 = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(r18, "fragment.requireActivity()");
        String r9 = this.fragment.getString(R.string.toast_join_blacklist_done);
        Intrinsics.checkNotNullExpressionValue(r9, "fragment.getString(R.str…oast_join_blacklist_done)");
        OToast.Companion.show$default(r8, r18, r9, 0, 4, null);
        if ((this.fragment.getActivity() instanceof ContactsActivity) == false) goto L30;
        FragmentActivity r10 = this.fragment.getActivity();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.android.contacts.ContactsActivity");
        ((ContactsActivity) r10).playBlacklistSound(true);
        goto L30
    L31:
        Intent r19 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI).putExtra("phone", r14.getNumber());
        Intrinsics.checkNotNullExpressionValue(r19, "Intent(Intent.ACTION_INS…nsert.PHONE, item.number)");
        AnimationUtil.startActivity(this.fragment.requireContext(), r19);
        return true;
    L33:
        CallLogItemView r110 = this.longPressedItemView;
        this.longPressedItemView = null;
        if (r110 == null) goto L36;
        this.onAnimateSwipeDelete.invoke(r14, r110);
    L37:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "longMenu: delete " + r14.getChildIds().size() + " records");
        return true;
    L36:
        this.viewModel.optimisticDelete(CollectionsKt.toSet(r14.getChildIds()));
        goto L37
    L39:
        AnimationUtil.startActivity(this.fragment.requireContext(), ContactsIntentUtils.getSendMessageIntent(r14.getNumber()));
        return true;
    L41:
        Object r111 = this.fragment.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) r111).setPrimaryClip(new ClipData(new ClipDescription("number", new String[]{HTTP.PLAIN_TEXT_TYPE, ClipboardReader.FORBIDDEN_CLIPBOARD_TYPE_CALL_LOG}), new ClipData.Item(r14.getNumber())));
        OToast.Companion r112 = OToast.Companion;
        FragmentActivity r113 = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(r113, "fragment.requireActivity()");
        String r114 = this.fragment.getString(R.string.copy_success);
        Intrinsics.checkNotNullExpressionValue(r114, "fragment.getString(R.string.copy_success)");
        r112.show(r113, r114, 80);
        return true;
    L13:
        if (r14.isMarked() == false) goto L15;
        this.onUnMarkNumber.invoke(r14.getNumber());
    L16:
        return true;
    L15:
        this.onMarkNumber.invoke(r14.getNumber(), Boolean.valueOf(r14.isMarked()));
        goto L16
    L5:
        r14 = null;
        goto L7
    }

    public final void dismissMenu() {
        LongMenuHelper r0 = this.longMenuHelper;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public final void destroy() {
        this.longMenuHelper = null;
    }

    static {
        Companion = new Companion(null);
        LONG_MENU_ITEMS_STRANGER = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_COPY_NUMBER, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_LINE, LongMenuHelper.MenuType.MENU_CREATE_CONTACTS, LongMenuHelper.MenuType.MENU_FLAG, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        LONG_MENU_ITEMS_CONTACTS = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_COPY_NUMBER, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_LINE, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        LONG_MENU_ITEMS_SINGLE = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_DELETE};
    }
}
