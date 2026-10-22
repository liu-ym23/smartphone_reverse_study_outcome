package com.obric.Intelligentcall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.settings.SettingsProviderHelper;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006()*+,-B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016J \u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0002J\u001a\u0010'\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "systemSound", "", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseDetail;", "customSound", "onItemClickListener", "Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$OnItemClickListener;)V", "isSwipeAction", "", "swipeItem", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "getDefaultTtsId", "", "item", "getDescription", "getDisplayTitle", "getItemCount", "", "getItemViewType", "position", "hideSwipedViews", "", "isVoiceChecked", "soundId", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCardPosition", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "listSize", "setCheckedItem", "BottomBtnViewHolder", "Companion", "CustomSoundViewHolder", "HeaderViewHolder", "OnItemClickListener", "SystemSoundViewHolder", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentSoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final int HEADER_COUNT = 1;
    private static final String TAG = "IntelligentSoundAdapter";
    private static final int VIEW_TYPE_BTN = 3;
    private static final int VIEW_TYPE_CUSTOM_SOUND = 2;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_SYS_SOUND = 1;
    private final Context context;
    private final List<SoundListGetResponseDetail> customSound;
    private boolean isSwipeAction;
    private final OnItemClickListener onItemClickListener;
    private ContactsCommonListItem swipeItem;
    private final List<SoundListGetResponseDetail> systemSound;

    /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$BottomBtnViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "getItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BottomBtnViewHolder extends RecyclerView.ViewHolder {
        private final OCardListItem item;

        public BottomBtnViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            View r3 = r2.findViewById(R.id.btn_layout);
            Intrinsics.checkNotNullExpressionValue(r3, "itemView.findViewById(R.id.btn_layout)");
            this.item = (OCardListItem) r3;
        }

        public final OCardListItem getItem() {
            return this.item;
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$Companion;", "", "()V", "HEADER_COUNT", "", "TAG", "", "VIEW_TYPE_BTN", "VIEW_TYPE_CUSTOM_SOUND", "VIEW_TYPE_HEADER", "VIEW_TYPE_SYS_SOUND", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$CustomSoundViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "item", "Lcom/obric/Intelligentcall/adapter/IntelligentSoundCardItem;", "getItem", "()Lcom/obric/Intelligentcall/adapter/IntelligentSoundCardItem;", "tips", "getTips", "()Landroid/view/View;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CustomSoundViewHolder extends RecyclerView.ViewHolder {
        private final IntelligentSoundCardItem item;
        private final View tips;

        public CustomSoundViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            View r0 = r2.findViewById(R.id.ai_intelligent_voice_item_tips);
            Intrinsics.checkNotNull(r0);
            this.tips = r0;
            View r3 = r2.findViewById(R.id.ai_intelligent_voice_item_left_item);
            Intrinsics.checkNotNull(r3);
            this.item = (IntelligentSoundCardItem) r3;
        }

        public final View getTips() {
            return this.tips;
        }

        public final IntelligentSoundCardItem getItem() {
            return this.item;
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$HeaderViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$OnItemClickListener;", "", "onCopyClick", "", "onDeleteClick", "data", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseDetail;", "position", "", "onEditClick", "onItemClick", "message", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemClickListener {

        /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onItemClick$default(OnItemClickListener r0, SoundListGetResponseDetail r1, int r2, String r3, int r4, Object r5) {
                if (r5 != null) goto L9;
                if ((r4 & 4) == 0) goto L6;
                r3 = null;
            L6:
                r0.onItemClick(r1, r2, r3);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemClick");
            }
        }

        void onCopyClick();

        void onDeleteClick(SoundListGetResponseDetail r1, int r2);

        void onEditClick(SoundListGetResponseDetail r1, int r2);

        void onItemClick(SoundListGetResponseDetail r1, int r2, String r3);
    }

    /* JADX INFO: compiled from: IntelligentSoundAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$SystemSoundViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "item", "Lcom/obric/Intelligentcall/adapter/IntelligentSoundCardItem;", "getItem", "()Lcom/obric/Intelligentcall/adapter/IntelligentSoundCardItem;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SystemSoundViewHolder extends RecyclerView.ViewHolder {
        private final IntelligentSoundCardItem item;

        public SystemSoundViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.item = (IntelligentSoundCardItem) r2;
        }

        public final IntelligentSoundCardItem getItem() {
            return this.item;
        }
    }

    public static /* synthetic */ void $r8$lambda$NmuZQW77jENWDGPJOn5HbsYvMps(IntelligentSoundAdapter r0, View r1) {
        onBindViewHolder$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$qyBZ6qNaFoM6ovZTR6hDxXXQbBY(IntelligentSoundAdapter r0, RecyclerView.ViewHolder r1, SoundListGetResponseDetail r2, int r3, View r4) {
        onBindViewHolder$lambda$0(r0, r1, r2, r3, r4);
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Context access$getContext$p(IntelligentSoundAdapter r0) {
        return r0.context;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(IntelligentSoundAdapter r0) {
        return r0.onItemClickListener;
    }

    public static final /* synthetic */ ContactsCommonListItem access$getSwipeItem$p(IntelligentSoundAdapter r0) {
        return r0.swipeItem;
    }

    public static final /* synthetic */ void access$hideSwipedViews(IntelligentSoundAdapter r0) {
        r0.hideSwipedViews();
    }

    public static final /* synthetic */ void access$setCheckedItem(IntelligentSoundAdapter r0, String r1, int r2) {
        r0.setCheckedItem(r1, r2);
    }

    public static final /* synthetic */ void access$setSwipeAction$p(IntelligentSoundAdapter r0, boolean r1) {
        r0.isSwipeAction = r1;
    }

    public static final /* synthetic */ void access$setSwipeItem$p(IntelligentSoundAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
    }

    public IntelligentSoundAdapter(Context r2, List<SoundListGetResponseDetail> r3, List<SoundListGetResponseDetail> r4, OnItemClickListener r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "systemSound");
        Intrinsics.checkNotNullParameter(r4, "customSound");
        Intrinsics.checkNotNullParameter(r5, "onItemClickListener");
        this.context = r2;
        this.systemSound = r3;
        this.customSound = r4;
        this.onItemClickListener = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L5;
        View r3 = LayoutInflater.from(this.context).inflate(R.layout.adapter_intelligent_voice_header, r4, false);
        Intrinsics.checkNotNullExpressionValue(r3, "view");
        return new HeaderViewHolder(r3);
    L5:
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L9;
        View r6 = LayoutInflater.from(this.context).inflate(R.layout.adapter_intelligent_voice_left_mode, r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "view");
        return new CustomSoundViewHolder(r6);
    L9:
        if (r5 != 3) goto L12;
        View r7 = LayoutInflater.from(this.context).inflate(R.layout.adapter_intelligent_voice_bottom_btn, r4, false);
        Intrinsics.checkNotNullExpressionValue(r7, "view");
        return new BottomBtnViewHolder(r7);
    L12:
        throw new IllegalArgumentException("Invalid view type");
    L19:
        return new SystemSoundViewHolder(new IntelligentSoundCardItem(this.context, null));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        if (r3 != 0) goto L5;
        return 0;
    L5:
        int r4 = r3 - 1;
        if (r4 >= this.systemSound.size()) goto L9;
        return 1;
    L9:
        if (r4 >= (this.systemSound.size() + this.customSound.size())) goto L11;
        return 2;
    L11:
        return 3;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ((this.systemSound.size() + 1) + this.customSound.size()) + 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        if ((r8 instanceof HeaderViewHolder) == false) goto L5;
        return;
    L5:
        if ((r8 instanceof SystemSoundViewHolder) == false) goto L8;
        final int r10 = r9 - 1;
        final SoundListGetResponseDetail r0 = this.systemSound.get(r10);
        String r1 = getDisplayTitle(r0);
        String r2 = getDescription(r0);
        SystemSoundViewHolder r3 = (SystemSoundViewHolder) r8;
        r3.getItem().setTitleText(r1);
        r3.getItem().setSubtitleText(r2);
        r3.getItem().setItemChecked(isVoiceChecked(r0.getSpeakerId()));
        setCardPosition(r3.getItem(), r10, this.systemSound.size());
        r3.getItem().setOnContentClickListener(new IntelligentSoundAdapter$$ExternalSyntheticLambda0(this, r8, r0, r10));
        return;
    L8:
        if ((r8 instanceof CustomSoundViewHolder) == false) goto L24;
        final int r11 = r9 - 1;
        int r4 = r11 - this.systemSound.size();
        if (r4 >= 0) goto L12;
        return;
    L12:
        if (r4 >= this.customSound.size()) goto L31;
        final SoundListGetResponseDetail r5 = this.customSound.get(r4);
        CustomSoundViewHolder r6 = (CustomSoundViewHolder) r8;
        View r7 = r6.getTips();
        int r12 = 0;
        if (r4 != 0) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == true) goto L21;
        r12 = 8;
    L21:
        r7.setVisibility(r12);
        r6.getItem().setTitleText(r5.getName());
        r6.getItem().setItemChecked(isVoiceChecked(r5.getSpeakerId()));
        setCardPosition(r6.getItem(), r4, this.customSound.size());
        r6.getItem().setOnClickListener(new AnonymousClass2(this, r5, r11));
        r6.getItem().setEnableSwipe(true);
        ArrayList r14 = new ArrayList();
        r14.add(SwipeItemButtonType.SWIPE_EDIT);
        r14.add(SwipeItemButtonType.SWIPE_DELETE);
        r6.getItem().setSwipeItemButtonView(r14, new AnonymousClass3(this, r5, r11));
        r6.getItem().addSwipeListener(new AnonymousClass4(this, r8));
        return;
    L17:
        r13 = false;
        goto L18
    L31:
        return;
    L24:
        if ((r8 instanceof BottomBtnViewHolder) == false) goto L35;
        hideSwipedViews();
        BottomBtnViewHolder r15 = (BottomBtnViewHolder) r8;
        OCardListItem r16 = r15.getItem();
        if (this.customSound.size() >= 5) goto L28;
        float r17 = 1.0f;
    L29:
        r16.setAlpha(r17);
        r15.getItem().setOnContentClickListener(new IntelligentSoundAdapter$$ExternalSyntheticLambda1(this));
        return;
    L28:
        r17 = 0.3f;
        goto L29
    }

    private static final void onBindViewHolder$lambda$0(IntelligentSoundAdapter r1, RecyclerView.ViewHolder r2, SoundListGetResponseDetail r3, int r4, View r5) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$holder");
        Intrinsics.checkNotNullParameter(r3, "$item");
        if (r1.isSwipeAction == false) goto L5;
        return;
    L5:
        r1.hideSwipedViews();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onBindViewHolder: item");
        ((SystemSoundViewHolder) r2).getItem().playLottie();
        r1.setCheckedItem(r3.getSpeakerId(), r4);
        r1.onItemClickListener.onItemClick(r3, r4, r1.getDefaultTtsId(r3));
    }

    private static final void onBindViewHolder$lambda$2(IntelligentSoundAdapter r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isSwipeAction == false) goto L5;
        return;
    L5:
        r1.hideSwipedViews();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onBindViewHolder: BottomBtnViewHolder item, count = " + r1.customSound.size());
        if (r1.customSound.size() >= 5) goto L8;
        r1.onItemClickListener.onCopyClick();
        return;
    L8:
        Context r3 = r1.context;
        Toast.makeText(r3, r3.getString(R.string.intelligent_sound_list_custom_toast), 0).show();
    }

    private final void hideSwipedViews() {
        ContactsCommonListItem r0 = this.swipeItem;
        if (r0 == null) goto L5;
        r0.swipeClose();
    L5:
        this.swipeItem = null;
    }

    private final boolean isVoiceChecked(String r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return TextUtils.equals(r2, SettingsProviderHelper.INSTANCE.getIntelligentVoiceCheckId(this.context));
    }

    private final void setCheckedItem(String r7, int r8) {
        String r0 = SettingsProviderHelper.INSTANCE.getIntelligentVoiceCheckId(this.context);
        SettingsProviderHelper.INSTANCE.setIntelligentVoiceCheckId(this.context, r7);
        Iterator r1 = CollectionsKt.plus(this.systemSound, this.customSound).iterator();
        boolean r2 = false;
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((SoundListGetResponseDetail) r1.next()).getSpeakerId(), r0) == true) goto L10;
        r3 = r3 + 1;
    L10:
        String r9 = r7;
        String r4 = r0;
        StringBuilder r5 = new StringBuilder("setCheckedItem position=").append(r8).append(", previousChecked=").append(r3).append(", changed=").append(!TextUtils.equals(r9, r4)).append(", hasCheckedId=");
        if (r4 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        StringBuilder r10 = r5.append(!r6).append(", hasTargetId=");
        if (r9 != null) goto L20;
    L21:
        r2 = true;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r10.append(!r2).toString());
        if (r3 < 0) goto L25;
        notifyItemChanged(r3 + 1);
    L25:
        notifyItemChanged(r8 + 1);
        return;
    L20:
        if (r9.length() != 0) goto L22;
    L13:
        if (r4.length() == 0) goto L16;
        r6 = false;
        goto L17
    L9:
        r3 = -1;
        goto L10
    }

    private final String getDisplayTitle(SoundListGetResponseDetail r3) {
        return IntelligentUtils.INSTANCE.getSystemDisplayName(this.context, r3.getSpeakerId(), r3.getName());
    }

    private final String getDefaultTtsId(SoundListGetResponseDetail r3) {
        String r4 = r3.getSpeakerId();
        if (r4 == null) goto L23;
        int r0 = r4.hashCode();
        if (r0 == (-977739836)) goto L20;
        if (r0 == (-661470386)) goto L16;
        if (r0 != 828824084) goto L23;
        if (r4.equals(IntelligentUtils.SPEAKER_ID_DFHR) == false) goto L23;
        String r2 = this.context.getString(R.string.intelligent_sound_panel_record_sys_dfhr_sound);
        Intrinsics.checkNotNullExpressionValue(r2, "context.getString(R.stri…el_record_sys_dfhr_sound)");
        return r2;
    L16:
        if (r4.equals("defaultSound") == false) goto L23;
        String r5 = this.context.getString(R.string.intelligent_sound_panel_record_sys_default_sound);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.stri…record_sys_default_sound)");
        return r5;
    L20:
        if (r4.equals(IntelligentUtils.SPEAKER_ID_SJXM) == false) goto L23;
        String r6 = this.context.getString(R.string.intelligent_sound_panel_record_sys_sjxm_sound);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.stri…el_record_sys_sjxm_sound)");
        return r6;
    L23:
        String r7 = this.context.getString(R.string.intelligent_sound_panel_record_custom_sound);
        Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.stri…anel_record_custom_sound)");
        return r7;
    }

    private final String getDescription(SoundListGetResponseDetail r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r0 = r4.getAge();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L21;
        String r3 = r4.getGender();
        if (r3 != null) goto L16;
    L17:
        r1 = true;
    L18:
        if (r1 == true) goto L21;
        return r4.getGender() + 65372 + r4.getAge();
    L16:
        if (r3.length() != 0) goto L18;
    L21:
        String r5 = r4.getSpeakerId();
        if (r5 == null) goto L43;
        int r6 = r5.hashCode();
        if (r6 == (-977739836)) goto L39;
        if (r6 == (-661470386)) goto L35;
        if (r6 != 828824084) goto L43;
        if (r5.equals(IntelligentUtils.SPEAKER_ID_DFHR) == false) goto L43;
        return this.context.getString(R.string.call_for_youth_male_voice_tips);
    L35:
        if (r5.equals("defaultSound") == false) goto L43;
        return this.context.getString(R.string.call_for_youth_female_voice_tips);
    L39:
        if (r5.equals(IntelligentUtils.SPEAKER_ID_SJXM) == false) goto L43;
        return this.context.getString(R.string.call_for_youth_female_voice_tips);
    L43:
        return this.context.getString(R.string.call_for_youth_female_voice_tips);
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    private final void setCardPosition(OCardListItem r4, int r5, int r6) {
        if (r5 != 0) goto L6;
        if (r6 != 1) goto L6;
        OCardListItem.setCardPosition$default(r4, 0, false, 2, null);
        return;
    L6:
        if (r5 != 0) goto L9;
        OCardListItem.setCardPosition$default(r4, 1, false, 2, null);
        return;
    L9:
        if (r5 != (r6 - 1)) goto L11;
        OCardListItem.setCardPosition$default(r4, 3, false, 2, null);
        return;
    L11:
        OCardListItem.setCardPosition$default(r4, 2, false, 2, null);
    }
}
