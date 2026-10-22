package com.stepos.ailauncher.taskstore.widget;

import Ua.C1060i;
import Ua.L0;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.common.imageloader.ImageDataSource;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.taskstore.R$color;
import com.stepos.ailauncher.taskstore.R$dimen;
import com.stepos.ailauncher.taskstore.R$drawable;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.ailauncher.taskstore.R$layout;
import com.stepos.ailauncher.taskstore.chat.TaskResultCodeItem;
import com.stepos.ailauncher.taskstore.chat.TaskResultCodePayload;
import com.stepos.ailauncher.taskstore.chat.TaskResultFileItem;
import com.stepos.ailauncher.taskstore.chat.TaskResultFilePayload;
import com.stepos.ailauncher.taskstore.livenotification.ArtifactExposureNotificationCanceller;
import com.stepos.ailauncher.taskstore.livenotification.C3715c;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Triple;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u6.C5579b;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 l2\u00020\u0001:\u0001mB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0014\u0010\u000eJ'\u0010\u0018\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ+\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b*\u0010&J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\n2\u0006\u00100\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020/H\u0002¢\u0006\u0004\b3\u00104J'\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b6\u00107J7\u0010<\u001a\u00020\n2\u0006\u00105\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u00162\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b<\u0010=J?\u0010?\u001a\u00020\n2\u0006\u00105\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u00162\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\n2\u0006\u00105\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\bA\u00102J\u000f\u0010B\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010\u000eJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\bC\u0010,J\u001b\u0010E\u001a\u0004\u0018\u00010\u001d2\b\u0010D\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\bI\u0010,J\u0017\u0010J\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0016H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bL\u0010\u000eR\u0018\u0010M\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR0\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0Oj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d`P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR$\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Sj\b\u0012\u0004\u0012\u00020\u001d`T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR0\u0010W\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0Oj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d`P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010RR$\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Sj\b\u0012\u0004\u0012\u00020\u001d`T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010VR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020:0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u0002080Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010[R$\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Sj\b\u0012\u0004\u0012\u00020\u001d`T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010VR$\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Sj\b\u0012\u0004\u0012\u00020\u001d`T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010VR\u0016\u0010_\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00103R\u0016\u0010`\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010(R\u0016\u0010a\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u00103R\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR$\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Sj\b\u0012\u0004\u0012\u00020\u001d`T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010VR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\n0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010k¨\u0006n"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TaskResultFileRowView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/stepos/ailauncher/taskstore/chat/I;", "data", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/ailauncher/taskstore/chat/I;)V", ExifInterface.LONGITUDE_WEST, "()V", "onAttachedToWindow", "", "isVisible", "onVisibilityAggregated", "(Z)V", "onDetachedFromWindow", "", "Lcom/stepos/ailauncher/taskstore/chat/H;", "artifacts", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/taskstore/chat/I;Ljava/util/List;)V", "X", "w", "", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", C3081a.FOCUS_MAP_NAME, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/ailauncher/taskstore/chat/I;Ljava/util/Map;)V", "item", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "F", "(Lcom/stepos/ailauncher/taskstore/chat/H;I)V", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Z", "(Lcom/stepos/ailauncher/taskstore/chat/H;Ljava/lang/String;)V", "b0", "h0", "(Lcom/stepos/ailauncher/taskstore/chat/H;)Z", "B", "(Ljava/util/List;)V", "Landroid/view/View;", "row", ExifInterface.LONGITUDE_EAST, "(Landroid/view/View;Lcom/stepos/ailauncher/taskstore/chat/H;)V", "I", "()Landroid/view/View;", "card", "D", "(Landroid/view/View;Lcom/stepos/ailauncher/taskstore/chat/H;I)V", "Landroid/widget/ImageView;", "image", "Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;", "shader", "e0", "(Landroid/view/View;Lcom/stepos/ailauncher/taskstore/chat/H;Landroid/widget/ImageView;Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;I)V", "url", "N", "(Landroid/view/View;Lcom/stepos/ailauncher/taskstore/chat/H;Landroid/widget/ImageView;Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;Ljava/lang/String;I)V", "H", "Y", "i0", "fileName", "L", "(Ljava/lang/String;)Ljava/lang/String;", "J", "(Lcom/stepos/ailauncher/taskstore/chat/H;)Ljava/lang/String;", "M", "Q", "(Lcom/stepos/ailauncher/taskstore/chat/H;)V", "a0", "payload", "Lcom/stepos/ailauncher/taskstore/chat/I;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "previewUrls", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "retriedFileIds", "Ljava/util/HashSet;", "codeContents", "fetchingCodeIds", "", "previewShaders", "Ljava/util/List;", "previewImages", "expiredFileIds", "blockedFileIds", "availabilityGeneration", "skipAvailabilityQuery", "bindGeneration", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "exposureTimer", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "exposedFileIds", "LUa/M;", "trackScope", "LUa/M;", "Lkotlin/Function0;", "availabilityChangedListener", "Lp9/a;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskResultFileRowView extends LinearLayout {
    private static final String TAG = "TaskResultFileRowView";
    private final InterfaceC5063a<Y8.t> availabilityChangedListener;
    private int availabilityGeneration;
    private int bindGeneration;
    private final HashSet<String> blockedFileIds;
    private final HashMap<String, String> codeContents;
    private final HashSet<String> expiredFileIds;
    private final HashSet<String> exposedFileIds;
    private final C3715c exposureTimer;
    private final HashSet<String> fetchingCodeIds;
    private TaskResultFilePayload payload;
    private final List<ImageView> previewImages;
    private final List<HalftoneShaderView> previewShaders;
    private final HashMap<String, String> previewUrls;
    private final HashSet<String> retriedFileIds;
    private boolean skipAvailabilityQuery;
    private Ua.M trackScope;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Runnable {
        final /* synthetic */ String $fileId$inlined;
        final /* synthetic */ int $generation$inlined;
        final /* synthetic */ TaskResultFileItem $item$inlined;
        final /* synthetic */ String $text$inlined;

        public b(String str, String str2, int i10, TaskResultFileItem taskResultFileItem) {
            this.$fileId$inlined = str;
            this.$text$inlined = str2;
            this.$generation$inlined = i10;
            this.$item$inlined = taskResultFileItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TaskResultFileRowView.this.fetchingCodeIds.remove(this.$fileId$inlined);
            TaskResultFileRowView.this.codeContents.put(this.$fileId$inlined, this.$text$inlined);
            if (this.$generation$inlined == TaskResultFileRowView.this.bindGeneration) {
                TaskResultFileRowView.this.Z(this.$item$inlined, this.$text$inlined);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        final /* synthetic */ Throwable $e$inlined;
        final /* synthetic */ String $fileId$inlined;

        public c(String str, Throwable th) {
            this.$fileId$inlined = str;
            this.$e$inlined = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TaskResultFileRowView.this.fetchingCodeIds.remove(this.$fileId$inlined);
            String str = "fetch code text failed, keep plain file row fileId=" + this.$fileId$inlined;
            Throwable th = this.$e$inlined;
            if (th != null) {
                C4148a.t(TaskResultFileRowView.TAG, str, th, false, 8, null);
            } else {
                C4148a.k(TaskResultFileRowView.TAG, str, false, 4, null);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Runnable {
        final /* synthetic */ View $card$inlined;
        final /* synthetic */ String $fileId$inlined;
        final /* synthetic */ int $generation$inlined;
        final /* synthetic */ ImageView $image$inlined;
        final /* synthetic */ TaskResultFileItem $item$inlined;
        final /* synthetic */ HalftoneShaderView $shader$inlined;
        final /* synthetic */ String $url$inlined;

        public d(String str, String str2, int i10, View view, TaskResultFileItem taskResultFileItem, ImageView imageView, HalftoneShaderView halftoneShaderView) {
            this.$fileId$inlined = str;
            this.$url$inlined = str2;
            this.$generation$inlined = i10;
            this.$card$inlined = view;
            this.$item$inlined = taskResultFileItem;
            this.$image$inlined = imageView;
            this.$shader$inlined = halftoneShaderView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TaskResultFileRowView.this.previewUrls.put(this.$fileId$inlined, this.$url$inlined);
            if (this.$generation$inlined == TaskResultFileRowView.this.bindGeneration) {
                TaskResultFileRowView.this.N(this.$card$inlined, this.$item$inlined, this.$image$inlined, this.$shader$inlined, this.$url$inlined, this.$generation$inlined);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements Runnable {
        final /* synthetic */ View $card$inlined;
        final /* synthetic */ Throwable $e$inlined;
        final /* synthetic */ String $fileId$inlined;
        final /* synthetic */ int $generation$inlined;
        final /* synthetic */ TaskResultFileItem $item$inlined;
        final /* synthetic */ TaskResultFileRowView this$0;

        public e(String str, Throwable th, int i10, TaskResultFileRowView taskResultFileRowView, View view, TaskResultFileItem taskResultFileItem) {
            this.$fileId$inlined = str;
            this.$e$inlined = th;
            this.$generation$inlined = i10;
            this.this$0 = taskResultFileRowView;
            this.$card$inlined = view;
            this.$item$inlined = taskResultFileItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = "resolve preview url failed fileId=" + this.$fileId$inlined;
            Throwable th = this.$e$inlined;
            if (th != null) {
                C4148a.t(TaskResultFileRowView.TAG, str, th, false, 8, null);
            } else {
                C4148a.u(TaskResultFileRowView.TAG, str, false, 4, null);
            }
            if (this.$generation$inlined == this.this$0.bindGeneration) {
                this.this$0.H(this.$card$inlined, this.$item$inlined);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskResultFileRowView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.previewUrls = new HashMap<>();
        this.retriedFileIds = new HashSet<>();
        this.codeContents = new HashMap<>();
        this.fetchingCodeIds = new HashSet<>();
        this.previewShaders = new ArrayList();
        this.previewImages = new ArrayList();
        this.expiredFileIds = new HashSet<>();
        this.blockedFileIds = new HashSet<>();
        this.exposureTimer = new C3715c(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.S
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskResultFileRowView.K(context, this, (String) obj);
            }
        });
        this.exposedFileIds = new HashSet<>();
        this.availabilityChangedListener = new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.T
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskResultFileRowView.z(this.f29341a);
            }
        };
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public static final void C(TaskResultFileRowView taskResultFileRowView, TaskResultFileItem taskResultFileItem, View view) {
        taskResultFileRowView.Q(taskResultFileItem);
    }

    public static final void G(TaskResultFileRowView taskResultFileRowView, TaskResultFileItem taskResultFileItem, View view) {
        taskResultFileRowView.Q(taskResultFileItem);
    }

    public static final Y8.t K(Context context, TaskResultFileRowView taskResultFileRowView, String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        ArtifactExposureNotificationCanceller.INSTANCE.b(context, taskId, TAG);
        taskResultFileRowView.a0();
        return Y8.t.f7040a;
    }

    public static final void O(int i10, TaskResultFileRowView taskResultFileRowView, HalftoneShaderView halftoneShaderView, TaskResultFileItem taskResultFileItem, View view, ImageView imageView, boolean z10, ImageDataSource source) {
        kotlin.jvm.internal.p.i(source, "source");
        if (i10 == taskResultFileRowView.bindGeneration) {
            if (z10) {
                halftoneShaderView.v(source == ImageDataSource.MEMORY_CACHE ? 0L : 220L);
                return;
            }
            if (!taskResultFileRowView.retriedFileIds.add(taskResultFileItem.getFileId())) {
                C4148a.u(TAG, "load preview failed after re-sign fileId=" + taskResultFileItem.getFileId(), false, 4, null);
                taskResultFileRowView.H(view, taskResultFileItem);
                return;
            }
            C4148a.u(TAG, "load preview failed, re-sign once fileId=" + taskResultFileItem.getFileId(), false, 4, null);
            taskResultFileRowView.previewUrls.remove(taskResultFileItem.getFileId());
            taskResultFileRowView.e0(view, taskResultFileItem, imageView, halftoneShaderView, i10);
        }
    }

    public static final void P(TaskResultFileRowView taskResultFileRowView) {
        taskResultFileRowView.X();
    }

    public static final void R(TaskResultFileRowView taskResultFileRowView) {
        taskResultFileRowView.X();
    }

    public static final Y8.t T(final TaskResultFileRowView taskResultFileRowView, final int i10, final TaskResultFilePayload taskResultFilePayload, final Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        taskResultFileRowView.post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.I
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                TaskResultFileRowView.U(i10, taskResultFileRowView, taskResultFilePayload, map);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void U(int i10, TaskResultFileRowView taskResultFileRowView, TaskResultFilePayload taskResultFilePayload, Map map) throws Resources.NotFoundException {
        if (i10 != taskResultFileRowView.availabilityGeneration) {
            return;
        }
        taskResultFileRowView.V(taskResultFilePayload, map);
    }

    public static final Y8.t c0(TaskResultFileRowView taskResultFileRowView, String str, int i10, TaskResultFileItem taskResultFileItem, String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            taskResultFileRowView.fetchingCodeIds.remove(str);
            taskResultFileRowView.codeContents.put(str, text);
            if (i10 == taskResultFileRowView.bindGeneration) {
                taskResultFileRowView.Z(taskResultFileItem, text);
            }
        } else {
            taskResultFileRowView.post(taskResultFileRowView.new b(str, text, i10, taskResultFileItem));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t d0(TaskResultFileRowView taskResultFileRowView, String str, Throwable th) {
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            taskResultFileRowView.fetchingCodeIds.remove(str);
            String str2 = "fetch code text failed, keep plain file row fileId=" + str;
            if (th != null) {
                C4148a.t(TAG, str2, th, false, 8, null);
            } else {
                C4148a.k(TAG, str2, false, 4, null);
            }
        } else {
            taskResultFileRowView.post(taskResultFileRowView.new c(str, th));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t f0(TaskResultFileRowView taskResultFileRowView, String str, int i10, View view, TaskResultFileItem taskResultFileItem, ImageView imageView, HalftoneShaderView halftoneShaderView, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            taskResultFileRowView.previewUrls.put(str, url);
            if (i10 == taskResultFileRowView.bindGeneration) {
                taskResultFileRowView.N(view, taskResultFileItem, imageView, halftoneShaderView, url, i10);
            }
        } else {
            taskResultFileRowView.post(taskResultFileRowView.new d(str, url, i10, view, taskResultFileItem, imageView, halftoneShaderView));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t g0(TaskResultFileRowView taskResultFileRowView, String str, int i10, View view, TaskResultFileItem taskResultFileItem, Throwable th) {
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            String str2 = "resolve preview url failed fileId=" + str;
            if (th != null) {
                C4148a.t(TAG, str2, th, false, 8, null);
            } else {
                C4148a.u(TAG, str2, false, 4, null);
            }
            if (i10 == taskResultFileRowView.bindGeneration) {
                taskResultFileRowView.H(view, taskResultFileItem);
            }
        } else {
            taskResultFileRowView.post(new e(str, th, i10, taskResultFileRowView, view, taskResultFileItem));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t x(final TaskResultFileRowView taskResultFileRowView, final int i10, final TaskResultFilePayload taskResultFilePayload, final Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        taskResultFileRowView.post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.G
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                TaskResultFileRowView.y(i10, taskResultFileRowView, taskResultFilePayload, map);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void y(int i10, TaskResultFileRowView taskResultFileRowView, TaskResultFilePayload taskResultFilePayload, Map map) throws Resources.NotFoundException {
        if (i10 != taskResultFileRowView.availabilityGeneration) {
            return;
        }
        taskResultFileRowView.V(taskResultFilePayload, map);
    }

    public static final Y8.t z(TaskResultFileRowView taskResultFileRowView) {
        taskResultFileRowView.w();
        return Y8.t.f7040a;
    }

    public final void A(TaskResultFilePayload data) throws Resources.NotFoundException {
        this.payload = data;
        this.exposedFileIds.clear();
        if (!this.skipAvailabilityQuery) {
            this.expiredFileIds.clear();
            this.blockedFileIds.clear();
        }
        Y();
        this.bindGeneration++;
        this.retriedFileIds.clear();
        removeAllViews();
        setBackground(null);
        setPadding(0, 0, 0, 0);
        setAlpha(1.0f);
        List<TaskResultFileItem> listB = data != null ? data.b() : null;
        if (listB == null) {
            listB = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB) {
            if (!La.H.x0(((TaskResultFileItem) obj).getFileId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!com.stepos.ailauncher.taskstore.chat.L.c((TaskResultFileItem) obj2)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            if (!this.blockedFileIds.contains(((TaskResultFileItem) obj3).getFileId())) {
                arrayList3.add(obj3);
            }
        }
        if (arrayList3.isEmpty()) {
            this.exposureTimer.b(null);
            setVisibility(8);
            return;
        }
        this.exposureTimer.b(data != null ? data.getTaskId() : null);
        setVisibility(0);
        if (arrayList3.size() == 1) {
            F((TaskResultFileItem) arrayList3.get(0), this.bindGeneration);
        } else {
            B(arrayList3);
        }
        S(data, arrayList3);
    }

    public final void B(List<TaskResultFileItem> artifacts) throws Resources.NotFoundException {
        setBackgroundResource(R$drawable.bg_task_result_file_multi);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.task_result_file_multi_padding_h);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.task_result_file_multi_padding_v);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i10 = 0;
        for (Object obj : artifacts) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            final TaskResultFileItem taskResultFileItem = (TaskResultFileItem) obj;
            if (i10 > 0) {
                addView(I());
            }
            View viewInflate = layoutInflaterFrom.inflate(R$layout.item_task_result_file_compact_row, (ViewGroup) this, false);
            kotlin.jvm.internal.p.f(viewInflate);
            E(viewInflate, taskResultFileItem);
            if (M(taskResultFileItem)) {
                viewInflate.setAlpha(0.5f);
            }
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.O
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskResultFileRowView.C(this.f29333a, taskResultFileItem, view);
                }
            });
            addView(viewInflate);
            i10 = i11;
        }
    }

    public final void D(View card, TaskResultFileItem item, int generation) {
        FrameLayout frameLayout = (FrameLayout) card.findViewById(R$id.layout_file_preview);
        HalftoneShaderView halftoneShaderView = (HalftoneShaderView) card.findViewById(R$id.shader_file_preview_loading);
        ImageView imageView = (ImageView) card.findViewById(R$id.iv_file_preview);
        if (!i0(item)) {
            H(card, item);
            return;
        }
        frameLayout.setVisibility(0);
        card.setBackgroundResource(R$drawable.bg_task_result_file_row_preview);
        this.previewShaders.add(halftoneShaderView);
        this.previewImages.add(imageView);
        String str = this.previewUrls.get(item.getFileId());
        if (str != null) {
            kotlin.jvm.internal.p.f(imageView);
            kotlin.jvm.internal.p.f(halftoneShaderView);
            N(card, item, imageView, halftoneShaderView, str, generation);
        } else {
            imageView.setVisibility(8);
            halftoneShaderView.t();
            kotlin.jvm.internal.p.f(imageView);
            kotlin.jvm.internal.p.f(halftoneShaderView);
            e0(card, item, imageView, halftoneShaderView, generation);
        }
    }

    public final void E(View row, TaskResultFileItem item) {
        ((ImageView) row.findViewById(R$id.iv_file_icon)).setImageResource(TaskMediumCardDecorationResolver.INSTANCE.n(item.getFileName(), item.getMimeType()));
        ((TextView) row.findViewById(R$id.tv_file_name)).setText(J(item));
    }

    public final void F(final TaskResultFileItem item, int generation) {
        if (h0(item)) {
            String str = this.codeContents.get(item.getFileId());
            if (str != null) {
                Z(item, str);
                return;
            }
            b0(item, generation);
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.item_task_result_file_row, (ViewGroup) this, false);
        kotlin.jvm.internal.p.f(viewInflate);
        E(viewInflate, item);
        if (M(item)) {
            viewInflate.setAlpha(0.5f);
            if (this.previewUrls.get(item.getFileId()) == null) {
                H(viewInflate, item);
            } else {
                D(viewInflate, item, generation);
                ((FrameLayout) viewInflate.findViewById(R$id.layout_file_preview)).setAlpha(0.5f);
            }
        } else {
            D(viewInflate, item, generation);
        }
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskResultFileRowView.G(this.f29330a, item, view);
            }
        });
        addView(viewInflate);
    }

    public final void H(View card, TaskResultFileItem item) {
        ((HalftoneShaderView) card.findViewById(R$id.shader_file_preview_loading)).u();
        ImageView imageView = (ImageView) card.findViewById(R$id.iv_file_preview);
        imageView.setVisibility(8);
        com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
        kotlin.jvm.internal.p.f(imageView);
        gVar.l(imageView);
        ((FrameLayout) card.findViewById(R$id.layout_file_preview)).setVisibility(8);
        card.setBackgroundResource(R$drawable.bg_task_result_file_multi);
    }

    public final View I() throws Resources.NotFoundException {
        View view = new View(getContext());
        view.setBackgroundColor(androidx.core.content.a.c(view.getContext(), R$color.task_result_file_divider));
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R$dimen.task_result_file_divider_gap);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, view.getResources().getDimensionPixelSize(R$dimen.task_result_file_divider_height));
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize;
        view.setLayoutParams(layoutParams);
        return view;
    }

    public final String J(TaskResultFileItem item) {
        u6.j jVar = u6.j.INSTANCE;
        TaskResultFilePayload taskResultFilePayload = this.payload;
        String taskId = taskResultFilePayload != null ? taskResultFilePayload.getTaskId() : null;
        if (taskId == null) {
            taskId = "";
        }
        String strB = jVar.b(taskId, item.getTitle(), item.getFileName(), item.getMimeType(), item.getCloudPath(), 0L, (64 & 64) != 0 ? null : null);
        if (!M(item)) {
            return strB;
        }
        C5579b c5579b = C5579b.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return c5579b.d(context, strB);
    }

    public final String L(String fileName) {
        return u6.j.INSTANCE.i(fileName, null, null);
    }

    public final boolean M(TaskResultFileItem item) {
        return this.expiredFileIds.contains(item.getFileId());
    }

    public final void N(final View card, final TaskResultFileItem item, final ImageView image, final HalftoneShaderView shader, String url, final int generation) {
        image.setVisibility(0);
        if (image.getDrawable() != null) {
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, image, new ImageRequest(url, 0, 0, null, null, 0, 0, 0, 0, true, null, true, false, false, false, null, 0.0f, false, 259582, null), null, null, null, 28, null);
            shader.u();
        } else {
            shader.t();
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, image, new ImageRequest(url, 0, 0, null, null, 0, 0, 0, 0, true, 220, false, false, false, false, null, 0.0f, false, 260606, null), null, new com.stepos.ailauncher.common.imageloader.b() { // from class: com.stepos.ailauncher.taskstore.widget.H
                @Override // com.stepos.ailauncher.common.imageloader.b
                public final void a(boolean z10, ImageDataSource imageDataSource) {
                    TaskResultFileRowView.O(generation, this, shader, item, card, image, z10, imageDataSource);
                }
            }, null, 20, null);
        }
    }

    public final void Q(TaskResultFileItem item) {
        if (La.H.x0(item.getFileId())) {
            return;
        }
        if (M(item)) {
            C5579b c5579b = C5579b.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            c5579b.c(context);
            return;
        }
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        String strB = C3738d.b(context2);
        String str = strB.length() > 0 ? strB : null;
        String fileId = item.getFileId();
        TaskResultFilePayload taskResultFilePayload = this.payload;
        String taskId = taskResultFilePayload != null ? taskResultFilePayload.getTaskId() : null;
        C4148a.k(TAG, "file row click fileId=" + fileId + " sessionId=" + str + " taskId=" + taskId + " name=" + item.getFileName(), false, 4, null);
        TaskResultFilePayload taskResultFilePayload2 = this.payload;
        SessionArtifact sessionArtifactB = com.stepos.ailauncher.taskstore.chat.G.b(item, str, taskResultFilePayload2 != null ? taskResultFilePayload2.getTaskId() : null);
        M5.c cVar = M5.c.INSTANCE;
        M5.c.b(cVar, sessionArtifactB, str, "chatview", null, cVar.e(item.getFileName(), item.getMimeType()), 8, null);
        Context context3 = getContext();
        kotlin.jvm.internal.p.h(context3, "getContext(...)");
        C3738d.d(context3, sessionArtifactB, null, 2, null);
    }

    public final void S(final TaskResultFilePayload data, List<TaskResultFileItem> artifacts) {
        if (this.skipAvailabilityQuery || data == null || artifacts.isEmpty()) {
            return;
        }
        final int i10 = this.availabilityGeneration + 1;
        this.availabilityGeneration = i10;
        com.stepos.ailauncher.taskstore.artifact.a aVar = com.stepos.ailauncher.taskstore.artifact.a.INSTANCE;
        List<TaskResultFileItem> list = artifacts;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TaskResultFileItem) it.next()).getFileId());
        }
        aVar.f(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.Q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskResultFileRowView.T(this.f29336a, i10, data, (Map) obj);
            }
        });
    }

    public final void V(TaskResultFilePayload data, Map<String, ? extends ArtifactAvailability> map) throws Resources.NotFoundException {
        C5579b c5579b = C5579b.INSTANCE;
        Set<String> setE = c5579b.e(map);
        Set<String> setA = c5579b.a(map);
        if (kotlin.jvm.internal.p.d(setE, this.expiredFileIds) && kotlin.jvm.internal.p.d(setA, this.blockedFileIds)) {
            return;
        }
        this.expiredFileIds.clear();
        this.expiredFileIds.addAll(setE);
        this.blockedFileIds.clear();
        this.blockedFileIds.addAll(setA);
        this.skipAvailabilityQuery = true;
        A(data);
        this.skipAvailabilityQuery = false;
    }

    public final void W() {
        this.exposureTimer.g();
        Ua.M m10 = this.trackScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.trackScope = null;
        Y();
        this.codeContents.clear();
        this.fetchingCodeIds.clear();
    }

    public final void X() {
        TaskResultFilePayload taskResultFilePayload;
        if (isShown() && (taskResultFilePayload = this.payload) != null) {
            List<TaskResultFileItem> listB = taskResultFilePayload.b();
            if (listB == null) {
                listB = C1173v.m();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : listB) {
                if (!La.H.x0(((TaskResultFileItem) obj).getFileId())) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            S(taskResultFilePayload, arrayList);
        }
    }

    public final void Y() {
        Iterator<T> it = this.previewShaders.iterator();
        while (it.hasNext()) {
            ((HalftoneShaderView) it.next()).u();
        }
        this.previewShaders.clear();
        for (ImageView imageView : this.previewImages) {
            try {
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.common.imageloader.g.INSTANCE.l(imageView);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.previewImages.clear();
    }

    public final void Z(TaskResultFileItem item, String content) {
        Y();
        removeAllViews();
        setBackground(null);
        setPadding(0, 0, 0, 0);
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        TaskResultCodeView taskResultCodeView = new TaskResultCodeView(context, null, 2, null);
        addView(taskResultCodeView);
        TaskResultFilePayload taskResultFilePayload = this.payload;
        String taskId = taskResultFilePayload != null ? taskResultFilePayload.getTaskId() : null;
        TaskResultFilePayload taskResultFilePayload2 = this.payload;
        TaskResultCodeView.t(taskResultCodeView, new TaskResultCodePayload(taskId, taskResultFilePayload2 != null ? taskResultFilePayload2.getVersionId() : null, C1172u.e(new TaskResultCodeItem(item.getFileId(), item.getCloudPath(), item.getFileName(), item.getTitle(), item.getMimeType(), item.getSize(), content, null, 128, null))), Z8.F.r1(this.expiredFileIds), null, 4, null);
    }

    public final void a0() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        String strB = C3738d.b(context);
        if (strB.length() <= 0) {
            strB = null;
        }
        TaskResultFilePayload taskResultFilePayload = this.payload;
        List<TaskResultFileItem> listB = taskResultFilePayload != null ? taskResultFilePayload.b() : null;
        if (listB == null) {
            listB = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listB) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            TaskResultFileItem taskResultFileItem = (TaskResultFileItem) obj;
            Triple triple = (La.H.x0(taskResultFileItem.getFileId()) || !this.exposedFileIds.add(taskResultFileItem.getFileId())) ? null : new Triple(taskResultFileItem, Integer.valueOf(i10), M5.c.INSTANCE.e(taskResultFileItem.getFileName(), taskResultFileItem.getMimeType()));
            if (triple != null) {
                arrayList.add(triple);
            }
            i10 = i11;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        TaskResultFilePayload taskResultFilePayload2 = this.payload;
        String taskId = taskResultFilePayload2 != null ? taskResultFilePayload2.getTaskId() : null;
        Ua.M mA = this.trackScope;
        if (mA == null) {
            mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
            this.trackScope = mA;
        }
        C1060i.d(mA, null, null, new TaskResultFileRowView$reportChatCardExpose$1(arrayList, taskId, strB, null), 3, null);
    }

    public final void b0(final TaskResultFileItem item, final int generation) {
        final String fileId = item.getFileId();
        if (this.fetchingCodeIds.add(fileId)) {
            com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.o(fileId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.J
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TaskResultFileRowView.c0(this.f29321a, fileId, generation, item, (String) obj);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.K
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TaskResultFileRowView.d0(this.f29325a, fileId, (Throwable) obj);
                }
            });
        }
    }

    public final void e0(final View card, final TaskResultFileItem item, final ImageView image, final HalftoneShaderView shader, final int generation) {
        final String fileId = item.getFileId();
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.n(fileId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.U
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskResultFileRowView.f0(this.f29342a, fileId, generation, card, item, image, shader, (String) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskResultFileRowView.g0(this.f29349a, fileId, generation, card, item, (Throwable) obj);
            }
        });
    }

    public final boolean h0(TaskResultFileItem item) {
        String strL = L(item.getFileName());
        if (strL != null) {
            return W.CODE_CARD_EXTS.contains(strL);
        }
        return Z8.F.f0(W.CODE_CARD_MIMES, u6.j.INSTANCE.j(item.getMimeType()));
    }

    public final boolean i0(TaskResultFileItem item) {
        String strL = L(item.getFileName());
        if (strL != null) {
            return W.PREVIEWABLE_EXTS.contains(strL);
        }
        return Z8.F.f0(W.PREVIEWABLE_MIMES, u6.j.INSTANCE.j(item.getMimeType()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.a(this.availabilityChangedListener);
        this.exposureTimer.e(isShown());
        post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.N
            @Override // java.lang.Runnable
            public final void run() {
                TaskResultFileRowView.P(this.f29332a);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.l(this.availabilityChangedListener);
        this.exposureTimer.g();
        Ua.M m10 = this.trackScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.trackScope = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        this.exposureTimer.e(isVisible);
        if (isVisible) {
            post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.P
                @Override // java.lang.Runnable
                public final void run() {
                    TaskResultFileRowView.R(this.f29335a);
                }
            });
        }
    }

    public final void w() {
        final TaskResultFilePayload taskResultFilePayload;
        if (isShown() && (taskResultFilePayload = this.payload) != null) {
            List<TaskResultFileItem> listB = taskResultFilePayload.b();
            if (listB == null) {
                listB = C1173v.m();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : listB) {
                if (!La.H.x0(((TaskResultFileItem) obj).getFileId())) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            final int i10 = this.availabilityGeneration;
            com.stepos.ailauncher.taskstore.artifact.a aVar = com.stepos.ailauncher.taskstore.artifact.a.INSTANCE;
            ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((TaskResultFileItem) it.next()).getFileId());
            }
            aVar.d(arrayList2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.L
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return TaskResultFileRowView.x(this.f29327a, i10, taskResultFilePayload, (Map) obj2);
                }
            });
        }
    }

    public /* synthetic */ TaskResultFileRowView(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
