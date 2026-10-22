package com.stepos.agentframework.chatui;

import Z8.C1174w;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatui.C2116w1;
import com.stepos.agentframework.chatui.viewholder.AbstractC2105j;
import com.stepos.agentframework.util.AgentImagePreviewActivity;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003FGHB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00112\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0011H\u0016¢\u0006\u0004\b \u0010!J\u001b\u0010$\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0019¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b)\u0010(J\u0015\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020*0\u0019¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00100\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020*8\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\"058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R.\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020*0\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010/R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\"0\u00198F¢\u0006\u0006\u001a\u0004\bC\u0010/¨\u0006I"}, d2 = {"Lcom/stepos/agentframework/chatui/w1;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/viewholder/j;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", "itemView", "deleteView", "LY8/t;", "o", "(Landroid/view/View;Landroid/view/View;)V", "q", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "t", "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/viewholder/j;", "holder", "position", "r", "(Lcom/stepos/agentframework/chatui/viewholder/j;I)V", "", "", "payloads", "s", "(Lcom/stepos/agentframework/chatui/viewholder/j;ILjava/util/List;)V", "getItemViewType", "(I)I", "getItemCount", "()I", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "newItems", "w", "(Ljava/util/List;)V", "imageItem", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "y", "", "fileId", "v", "(Ljava/lang/String;)V", "n", "()Ljava/util/List;", "Landroid/content/Context;", "l", "()Landroid/content/Context;", "TAG", "Ljava/lang/String;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "readyStatus", "I", "Lkotlin/Function1;", "onDataReadyStateChanged", "Lp9/l;", "getOnDataReadyStateChanged", "()Lp9/l;", "x", "(Lp9/l;)V", "m", "previewLocalPaths", "k", "allItems", "Companion", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.w1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2116w1 extends RecyclerView.Adapter<AbstractC2105j> {
    private static final int DELETE_TOUCH_TARGET_DP = 32;
    public static final String PAYLOAD_UPDATE_PROGRESS = "update_progress";
    public static final int PIC_AND_FILE_READY_STATUS_EMPTY = 0;
    public static final int PIC_AND_FILE_READY_STATUS_READY = 1;
    public static final int PIC_AND_FILE_READY_STATUS_UPLOADING = -1;
    private final String TAG;
    private final Context context;
    private final List<FileInfo> items;
    private InterfaceC5074l<? super Integer, Y8.t> onDataReadyStateChanged;
    private int readyStatus;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatui/w1$a;", "Lcom/stepos/agentframework/chatui/viewholder/j;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/agentframework/chatui/w1;Landroid/view/View;)V", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "item", "", "position", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;I)V", "imageItem", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "Landroid/widget/ImageView;", "ivFileIcon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvFileName", "Landroid/widget/TextView;", "tvFileType", "tvFileSize", "ivDelete", "Landroid/view/View;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.w1$a */
    public final class a extends AbstractC2105j {
        private final View ivDelete;
        private final ImageView ivFileIcon;
        final /* synthetic */ C2116w1 this$0;
        private final TextView tvFileName;
        private final TextView tvFileSize;
        private final TextView tvFileType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C2116w1 c2116w1, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = c2116w1;
            View viewFindViewById = itemView.findViewById(R$id.iv_file_icon);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.ivFileIcon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tv_file_name);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.tvFileName = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.tv_file_type);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.tvFileType = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.tv_file_size);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.tvFileSize = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R$id.btn_delete);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.ivDelete = viewFindViewById5;
        }

        public static final void d(a aVar, C2116w1 c2116w1, View view) {
            int bindingAdapterPosition = aVar.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || bindingAdapterPosition >= c2116w1.items.size()) {
                return;
            }
            c2116w1.items.remove(bindingAdapterPosition);
            c2116w1.notifyItemRemoved(bindingAdapterPosition);
            if (bindingAdapterPosition < c2116w1.items.size()) {
                c2116w1.notifyItemRangeChanged(bindingAdapterPosition, c2116w1.items.size() - bindingAdapterPosition);
            }
            c2116w1.q();
        }

        @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2105j
        public void a(FileInfo item, int position) {
            String str;
            kotlin.jvm.internal.p.i(item, "item");
            this.ivFileIcon.setImageResource(Q1.INSTANCE.b(item.getFileType()));
            this.tvFileName.setText(item.getFileName());
            TextView textView = this.tvFileType;
            switch (item.getFileType()) {
                case 2:
                    str = "VIDEO";
                    break;
                case 3:
                case 8:
                    str = "DOC";
                    break;
                case 4:
                    str = "PDF";
                    break;
                case 5:
                case 6:
                default:
                    str = "FILE";
                    break;
                case 7:
                    str = "PPT";
                    break;
                case 9:
                    str = "XLS";
                    break;
                case 10:
                    str = "TXT";
                    break;
                case 11:
                    str = "MD";
                    break;
            }
            textView.setText(str);
            this.tvFileSize.setText(item.getFileSize());
            View view = this.ivDelete;
            final C2116w1 c2116w1 = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.v1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2116w1.a.d(this.f23078a, c2116w1, view2);
                }
            });
            C2116w1 c2116w12 = this.this$0;
            View itemView = this.itemView;
            kotlin.jvm.internal.p.h(itemView, "itemView");
            c2116w12.o(itemView, this.ivDelete);
        }

        @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2105j
        public void b(FileInfo imageItem) {
            kotlin.jvm.internal.p.i(imageItem, "imageItem");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatui/w1$b;", "Lcom/stepos/agentframework/chatui/viewholder/j;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/agentframework/chatui/w1;Landroid/view/View;)V", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "item", "", "position", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;I)V", "imageItem", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "ivDelete", "Landroid/view/View;", "Landroid/widget/ImageView;", "ivImage", "Landroid/widget/ImageView;", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "progressBar", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "ivImageMask", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.w1$b */
    public final class b extends AbstractC2105j {
        private final View ivDelete;
        private final ImageView ivImage;
        private final View ivImageMask;
        private final CircularProgressIndicator progressBar;
        final /* synthetic */ C2116w1 this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatui.w1$b$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FileInfo.UploadState.values().length];
                try {
                    iArr[FileInfo.UploadState.SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileInfo.UploadState.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FileInfo.UploadState.UPLOADING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2116w1 c2116w1, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = c2116w1;
            View viewFindViewById = itemView.findViewById(R$id.btn_delete);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.ivDelete = viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.iv_image);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.ivImage = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.progress_bar);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.progressBar = (CircularProgressIndicator) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.iv_image_mask);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.ivImageMask = viewFindViewById4;
        }

        public static final void f(b bVar, C2116w1 c2116w1, View view) {
            int bindingAdapterPosition = bVar.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || bindingAdapterPosition >= c2116w1.items.size()) {
                return;
            }
            c2116w1.items.remove(bindingAdapterPosition);
            c2116w1.notifyItemRemoved(bindingAdapterPosition);
            if (bindingAdapterPosition < c2116w1.items.size()) {
                c2116w1.notifyItemRangeChanged(bindingAdapterPosition, c2116w1.items.size() - bindingAdapterPosition);
            }
            c2116w1.q();
        }

        public static final void g(b bVar, C2116w1 c2116w1, int i10, View view) {
            View rootView = bVar.itemView.getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup == null) {
                AgentImagePreviewActivity.Companion.b(AgentImagePreviewActivity.INSTANCE, c2116w1.getContext(), i10, c2116w1.m(), false, 8, null);
                return;
            }
            final com.stepos.agentframework.util.u uVar = new com.stepos.agentframework.util.u(c2116w1.getContext(), c2116w1.m(), i10, viewGroup, false, false, 48, null);
            uVar.W(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.z1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2116w1.b.h(uVar);
                }
            });
            uVar.X();
        }

        public static final Y8.t h(com.stepos.agentframework.util.u uVar) {
            uVar.D();
            return Y8.t.f7040a;
        }

        @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2105j
        public void a(FileInfo item, final int position) {
            kotlin.jvm.internal.p.i(item, "item");
            Uri fileUri = item.getFileUri();
            String path = fileUri.getPath();
            if (path == null || path.length() == 0) {
                fileUri = null;
            }
            String filePath = item.getFilePath();
            RequestManager requestManagerWith = Glide.with(this.itemView.getContext());
            if (fileUri != null) {
                filePath = fileUri;
            }
            RequestBuilder<Drawable> requestBuilderLoad = requestManagerWith.load((Object) filePath);
            CenterCrop centerCrop = new CenterCrop();
            O6.d dVar = O6.d.INSTANCE;
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            requestBuilderLoad.transform(centerCrop, new RoundedCorners(dVar.a(context, 8.0f))).into(this.ivImage);
            C4148a.k(this.this$0.TAG, "Loading image: " + fileUri, false, 4, null);
            i(item);
            View view = this.ivDelete;
            final C2116w1 c2116w1 = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.x1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2116w1.b.f(this.f23226a, c2116w1, view2);
                }
            });
            C2116w1 c2116w12 = this.this$0;
            View itemView = this.itemView;
            kotlin.jvm.internal.p.h(itemView, "itemView");
            c2116w12.o(itemView, this.ivDelete);
            View view2 = this.itemView;
            final C2116w1 c2116w13 = this.this$0;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.y1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    C2116w1.b.g(this.f23229a, c2116w13, position, view3);
                }
            });
        }

        @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2105j
        public void b(FileInfo imageItem) {
            kotlin.jvm.internal.p.i(imageItem, "imageItem");
            i(imageItem);
        }

        public final void i(FileInfo imageItem) {
            kotlin.jvm.internal.p.i(imageItem, "imageItem");
            this.progressBar.setProgress(imageItem.getProgress());
            int i10 = a.$EnumSwitchMapping$0[imageItem.getUploadState().ordinal()];
            if (i10 == 1) {
                this.progressBar.setVisibility(8);
                this.ivImageMask.setVisibility(8);
            } else if (i10 == 2) {
                this.progressBar.setVisibility(0);
                this.ivImageMask.setVisibility(0);
            } else if (i10 != 3) {
                this.progressBar.setVisibility(0);
                this.ivImageMask.setVisibility(0);
            } else {
                this.progressBar.setVisibility(0);
                this.ivImageMask.setVisibility(0);
            }
        }
    }

    public C2116w1(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.TAG = "ChatInputImageAdapter";
        this.items = new ArrayList();
        this.onDataReadyStateChanged = new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.u1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2116w1.u(((Integer) obj).intValue());
            }
        };
    }

    public static final void p(View view, View view2) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || view2.getVisibility() != 0) {
            return;
        }
        Rect rect = new Rect();
        view2.getHitRect(rect);
        int i10 = (int) (32 * view.getResources().getDisplayMetrics().density);
        rect.inset(-C5685n.f((i10 - rect.width()) / 2, 0), -C5685n.f((i10 - rect.height()) / 2, 0));
        rect.left = C5685n.f(rect.left, 0);
        rect.top = C5685n.f(rect.top, 0);
        rect.right = C5685n.j(rect.right, view.getWidth());
        rect.bottom = C5685n.j(rect.bottom, view.getHeight());
        view.setTouchDelegate(new TouchDelegate(rect, view2));
    }

    public static final Y8.t u(int i10) {
        return Y8.t.f7040a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getFileType();
    }

    public final void j(FileInfo imageItem) {
        kotlin.jvm.internal.p.i(imageItem, "imageItem");
        this.items.add(imageItem);
        notifyItemInserted(this.items.size() - 1);
        C4148a.k(this.TAG, "Added image, item: " + imageItem, false, 4, null);
        q();
    }

    public final List<FileInfo> k() {
        return Z8.F.m1(this.items);
    }

    /* renamed from: l, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final List<String> m() {
        List<FileInfo> list = this.items;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String filePath = ((FileInfo) it.next()).getFilePath();
            if (filePath == null || La.H.x0(filePath)) {
                filePath = null;
            }
            if (filePath != null) {
                arrayList.add(filePath);
            }
        }
        return arrayList;
    }

    public final List<String> n() {
        String filePath;
        List<FileInfo> list = this.items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            FileInfo fileInfo = (FileInfo) obj;
            if (fileInfo.getUploadState() == FileInfo.UploadState.SUCCESS && (filePath = fileInfo.getFilePath()) != null && filePath.length() != 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FileInfo) it.next()).getFilePath());
        }
        return arrayList2;
    }

    public final void o(final View itemView, final View deleteView) {
        itemView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.t1
            @Override // java.lang.Runnable
            public final void run() {
                C2116w1.p(itemView, deleteView);
            }
        });
    }

    public final void q() {
        int i10 = this.items.isEmpty() ? 0 : this.items.size() == n().size() ? 1 : -1;
        this.readyStatus = i10;
        this.onDataReadyStateChanged.invoke(Integer.valueOf(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC2105j holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.a(this.items.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC2105j holder, int position, List<? extends Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        Iterator<? extends Object> it = payloads.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.p.d(it.next(), "update_progress")) {
                holder.b(this.items.get(position));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public AbstractC2105j onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_image, parent, false);
            kotlin.jvm.internal.p.f(viewInflate);
            return new b(this, viewInflate);
        }
        if (viewType == 3 || viewType == 4) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_file, parent, false);
            kotlin.jvm.internal.p.f(viewInflate2);
            return new a(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_file, parent, false);
        kotlin.jvm.internal.p.f(viewInflate3);
        return new a(this, viewInflate3);
    }

    public final void v(String fileId) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        Iterator<FileInfo> it = this.items.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (kotlin.jvm.internal.p.d(it.next().getFileId(), fileId)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            this.items.remove(i10);
            notifyItemRemoved(i10);
            if (i10 != this.items.size()) {
                notifyItemRangeChanged(i10, this.items.size() - i10);
            }
            q();
        }
    }

    public final void w(List<FileInfo> newItems) {
        kotlin.jvm.internal.p.i(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
        q();
    }

    public final void x(InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l) {
        kotlin.jvm.internal.p.i(interfaceC5074l, "<set-?>");
        this.onDataReadyStateChanged = interfaceC5074l;
    }

    public final void y(FileInfo imageItem) {
        kotlin.jvm.internal.p.i(imageItem, "imageItem");
        Iterator<FileInfo> it = this.items.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (kotlin.jvm.internal.p.d(it.next().getFileId(), imageItem.getFileId())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            this.items.set(i10, imageItem);
            notifyItemChanged(i10, "update_progress");
            C4148a.d(this.TAG, "Updated progress for item: " + imageItem + ", progress: " + imageItem.getProgress(), false, 4, null);
            if (imageItem.getUploadState() == FileInfo.UploadState.SUCCESS) {
                q();
            }
        }
    }
}
