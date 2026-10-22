package com.bytedance.android.live.effect.sticker.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import com.bytedance.android.live.effect.sticker.presenter.j;
import com.bytedance.android.live.effect.sticker.presenter.k;
import com.bytedance.android.live.effect.sticker.presenter.n0;
import com.bytedance.android.live.effect.sticker.presenter.s;
import com.bytedance.android.live.effect.sticker.presenter.t;
import com.bytedance.android.live.effect.sticker.presenter.u;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelClickType;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatus;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatusBundleKey;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\b@\u0010AJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005R#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001eR&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001f0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u001e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c068F¢\u0006\u0006\u001a\u0004\b7\u00108R#\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f068F¢\u0006\u0006\u001a\u0004\b:\u00108R#\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001f068F¢\u0006\u0006\u001a\u0004\b<\u00108R\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$068F¢\u0006\u0006\u001a\u0004\b>\u00108¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerAigcViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "", "paths", "", "setImageListToAigcSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "keyword", "imagePathList", "onCommitAigcTaskFinish", "updateAigcTaskPanelStatus", "clearAigcStickerRenderCache", "hideAigcHint", "Lcom/bytedance/android/live/effect/sticker/presenter/s;", "kotlin.jvm.PlatformType", "aigcTaskManager$delegate", "Lkotlin/Lazy;", "getAigcTaskManager", "()Lcom/bytedance/android/live/effect/sticker/presenter/s;", "aigcTaskManager", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Landroidx/lifecycle/MutableLiveData;", "", "_aigcTaskPanelVisible", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelStatus;", "Landroid/os/Bundle;", "_aigcTaskPanelStatus", "_aigcHintStatus", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/b;", "_aigcTaskPanelListener", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "stickerRenderViewModel", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "getStickerDialogUIViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "stickerDialogUIViewModel", "Landroidx/lifecycle/LiveData;", "getAigcTaskPanelVisible", "()Landroidx/lifecycle/LiveData;", "aigcTaskPanelVisible", "getAigcTaskPanelStatus", "aigcTaskPanelStatus", "getAigcHintStatus", "aigcHintStatus", "getAigcTaskPanelListener", "aigcTaskPanelListener", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerAigcViewModel extends StickerBaseViewModel {
    private final MutableLiveData<Pair<Boolean, String>> _aigcHintStatus;
    private MutableLiveData<com.bytedance.android.live.effect.sticker.ui.aigc.b> _aigcTaskPanelListener;
    private final MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> _aigcTaskPanelStatus;
    private final MutableLiveData<Boolean> _aigcTaskPanelVisible;
    private final Lazy aigcTaskManager$delegate;
    private final Lazy composerManager$delegate;
    private final String panel;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerAigcViewModel f68789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f68790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f68791c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.effect.sticker.presenter.k
        public final void a(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "succeedPathList");
            StickerRenderViewModel r101 = StickerAigcViewModel.access$getStickerRenderViewModel$p(this.f68789a);
            if (r101 == null) goto L15;
            LiveData<Sticker> r102 = r101.getRenderStickerData();
            if (r102 == null) goto L16;
            Sticker r103 = r102.getValue();
            if (r103 != null) goto L9;
            return;
        L9:
            if (r103.getId() == this.f68790b.getId()) goto L11;
            return;
        L11:
            if (r100.isEmpty() == false) goto L13;
            MutableLiveData r104 = StickerAigcViewModel.access$get_aigcTaskPanelStatus$p(this.f68789a);
            AigcTaskPanelStatus r105 = AigcTaskPanelStatus.Done;
            Bundle r106 = new Bundle();
            r106.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), (String) this.f68791c.element);
            Unit r107 = Unit.INSTANCE;
            r104.setValue(new Pair(r105, r106));
            StickerAigcViewModel.access$get_aigcHintStatus$p(this.f68789a).setValue(new Pair(Boolean.TRUE, s1.B(R.string.ttlive_effect_aigc_task_history_apply_fail_hint)));
            return;
        L13:
            StickerAigcViewModel.access$setImageListToAigcSticker(this.f68789a, r100);
            MutableLiveData r108 = StickerAigcViewModel.access$get_aigcTaskPanelStatus$p(this.f68789a);
            AigcTaskPanelStatus r109 = AigcTaskPanelStatus.Ready;
            Bundle r110 = new Bundle();
            r110.putBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), true);
            Unit r111 = Unit.INSTANCE;
            r108.setValue(new Pair(r109, r110));
            StickerAigcViewModel.access$getAigcTaskManager$p(this.f68789a).m(this.f68790b, (String) this.f68791c.element, StickerAigcViewModel.access$getScene$p(this.f68789a).getPage());
            return;
        L16:
            return;
        }

        public a(StickerAigcViewModel r100, Sticker r101, Ref.ObjectRef r102) {
            this.f68789a = r100;
            this.f68790b = r101;
            this.f68791c = r102;
        }
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.ui.aigc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerAigcViewModel f68792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f68793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Sticker f68794c;

        public static final class a implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f68795a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f68796b;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel$b$a$a, reason: collision with other inner class name */
            public static final class C1119a implements n0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f68797a;

                /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel$b$a$a$a, reason: collision with other inner class name */
                public static final class C1120a implements k {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ C1119a f68798a;

                    public C1120a(C1119a r100) {
                        this.f68798a = r100;
                    }

                    @Override // com.bytedance.android.live.effect.sticker.presenter.k
                    public final void a(List<String> r100) {
                        Intrinsics.checkNotNullParameter(r100, "succeedPathList");
                        a r101 = this.f68798a.f68797a;
                        b r102 = r101.f68795a;
                        StickerAigcViewModel.access$onCommitAigcTaskFinish(r102.f68792a, r102.f68794c, r101.f68796b, r100);
                    }
                }

                public C1119a(a r100) {
                    this.f68797a = r100;
                }

                @Override // com.bytedance.android.live.effect.sticker.presenter.n0
                public final void a(AigcBackgroundImageGenerateTask r100) {
                    Intrinsics.checkNotNullParameter(r100, "task");
                    if (r100.getStatus() != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L24;
                    s r101 = StickerAigcViewModel.access$getAigcTaskManager$p(this.f68797a.f68795a.f68792a);
                    long r102 = r100.getTaskID();
                    r101.getClass();
                    Intrinsics.checkNotNullParameter(this, "listener");
                    Map<Long, List<n0>> r103 = r101.f68371c;
                    LinkedHashMap r104 = (LinkedHashMap) r103;
                    List r105 = (List) r104.get(Long.valueOf(r102));
                    if (r105 == null) goto L7;
                    r105.remove(this);
                L7:
                    ArrayList r106 = new ArrayList();
                    Iterator<ImageModel> r107 = r100.getImageList().iterator();
                L9:
                    if (r107.hasNext() == false) goto L15;
                    List<String> r108 = r107.next().getUrls();
                    if (r108 == null) goto L9;
                    String r109 = (String) CollectionsKt.firstOrNull(r108);
                    if (r109 == null) goto L9;
                    r106.add(r109);
                    goto L9
                L15:
                    StickerAigcViewModel.access$getAigcTaskManager$p(this.f68797a.f68795a.f68792a).d(r106, new C1120a(this));
                    return;
                }
            }

            @Override // com.bytedance.android.live.effect.sticker.presenter.j
            public final void onFail() {
                b r100 = this.f68795a;
                StickerAigcViewModel.access$onCommitAigcTaskFinish(r100.f68792a, r100.f68794c, this.f68796b, CollectionsKt.emptyList());
            }

            @Override // com.bytedance.android.live.effect.sticker.presenter.j
            public final void a(AigcBackgroundImageGenerateTask r100) {
                Intrinsics.checkNotNullParameter(r100, "task");
                StickerRenderViewModel r101 = StickerAigcViewModel.access$getStickerRenderViewModel$p(this.f68795a.f68792a);
                if (r101 == null) goto L21;
                LiveData<Sticker> r102 = r101.getRenderStickerData();
                if (r102 == null) goto L22;
                Sticker r103 = r102.getValue();
                if (r103 != null) goto L9;
                return;
            L9:
                if (r103.getId() != this.f68795a.f68794c.getId()) goto L24;
                s r104 = StickerAigcViewModel.access$getAigcTaskManager$p(this.f68795a.f68792a);
                long r105 = r100.getTaskID();
                C1119a r106 = new C1119a(this);
                r104.getClass();
                Intrinsics.checkNotNullParameter(r106, "listener");
                Map<Long, List<n0>> r107 = r104.f68371c;
                LinkedHashMap r108 = (LinkedHashMap) r107;
                if (r108.get(Long.valueOf(r105)) != null) goto L13;
                r104.f68371c.put(Long.valueOf(r105), new ArrayList());
            L13:
                Map<Long, List<n0>> r109 = r104.f68371c;
                LinkedHashMap r110 = (LinkedHashMap) r109;
                List r111 = (List) r110.get(Long.valueOf(r105));
                if (r111 != null) goto L16;
            L17:
                Map<Long, List<n0>> r112 = r104.f68371c;
                LinkedHashMap r113 = (LinkedHashMap) r112;
                List r114 = (List) r113.get(Long.valueOf(r105));
                if (r114 == null) goto L26;
                r114.add(r106);
                return;
            L26:
                return;
            L16:
                if (r111.contains(r106) != true) goto L17;
                return;
            L24:
                return;
            L22:
                return;
            }

            public a(b r100, String r101) {
                this.f68795a = r100;
                this.f68796b = r101;
            }
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void b() {
            StickerDialogUIViewModel r100 = StickerAigcViewModel.access$getStickerDialogUIViewModel$p(this.f68792a);
            if (r100 == null) goto L8;
            com.bytedance.live.datacontext.k<Unit> r101 = r100.getHideDialogEvent();
            if (r101 == null) goto L9;
            r101.post(Unit.INSTANCE);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "keyword");
            List<String> r101 = q.f68881a;
            q.c(this.f68794c, r100, AigcTaskPanelClickType.ReSelectKeyword, StickerAigcViewModel.access$getScene$p(this.f68792a).getPage());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void d(AigcTaskPanelStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "status");
            if (r100 == AigcTaskPanelStatus.Running) goto L11;
            MutableLiveData r101 = StickerAigcViewModel.access$get_aigcHintStatus$p(this.f68792a);
            Boolean r102 = Boolean.FALSE;
            Pair r103 = (Pair) StickerAigcViewModel.access$get_aigcHintStatus$p(this.f68792a).getValue();
            if (r103 == null) goto L8;
            String r104 = (String) r103.getSecond();
            if (r104 == null) goto L8;
        L9:
            r101.setValue(new Pair(r102, r104));
            return;
        L8:
            r104 = "";
            goto L9
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void c(String r110, AigcTaskPanelClickType r111) {
            Intrinsics.checkNotNullParameter(r110, "keyword");
            Intrinsics.checkNotNullParameter(r111, "clickType");
            MutableLiveData r100 = StickerAigcViewModel.access$get_aigcTaskPanelStatus$p(this.f68792a);
            AigcTaskPanelStatus r101 = AigcTaskPanelStatus.Running;
            Bundle r102 = new Bundle();
            r102.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), r110);
            boolean r103 = true;
            r102.putBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), true);
            Unit r104 = Unit.INSTANCE;
            r100.setValue(new Pair(r101, r102));
            s r105 = StickerAigcViewModel.access$getAigcTaskManager$p(this.f68792a);
            long r106 = this.f68793b;
            String r112 = this.f68794c.getAigcEffectInfo().getModelPrompt(r110);
            String r113 = this.f68794c.getAigcEffectInfo().getModelReqKey();
            a r107 = new a(this, r110);
            r105.getClass();
            Intrinsics.checkNotNullParameter(r110, "keyword");
            Intrinsics.checkNotNullParameter(r112, "modelKeyword");
            Intrinsics.checkNotNullParameter(r113, "modelReqKey");
            com.bytedance.android.live.effect.sticker.presenter.g r108 = (com.bytedance.android.live.effect.sticker.presenter.g) ((LinkedHashMap) r105.f68370b).get(Long.valueOf(r106));
            if (r108 == null) goto L5;
            List<Long> r109 = r108.f68319b;
        L6:
            if (r109 != null) goto L8;
        L11:
            if (r103 == false) goto L13;
            RxUtilKt.c(((LiveEffectApi) com.bytedance.android.live.network.c.b().e(LiveEffectApi.class)).commitAigcBackgroundImageGenerateTask(r106, r110, r112, r113).compose(RxUtil.rxSchedulerHelper()).subscribe(new t(r105, r106, r107), new u(r107)), r105.f68369a);
        L14:
            List<String> r114 = q.f68881a;
            q.c(this.f68794c, r110, r111, StickerAigcViewModel.access$getScene$p(this.f68792a).getPage());
            return;
        L13:
            ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", r106 + " has running tasks, fail to commit new task");
            goto L14
        L8:
            if (r109.isEmpty() == true) goto L11;
            r103 = false;
            goto L11
        L5:
            r109 = null;
            goto L6
        }

        public b(StickerAigcViewModel r100, long r101, Sticker r102) {
            this.f68792a = r100;
            this.f68793b = r101;
            this.f68794c = r102;
        }
    }

    private final s getAigcTaskManager() {
        return (s) this.aigcTaskManager$delegate.getValue();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    private final StickerDialogUIViewModel getStickerDialogUIViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.scene;
        r100.getClass();
        return (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r101, StickerDialogUIViewModel.class);
    }

    private final StickerRenderViewModel getStickerRenderViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.scene;
        r100.getClass();
        return (StickerRenderViewModel) StickerBaseViewModel.a.a(r101, StickerRenderViewModel.class);
    }

    public final void clearAigcStickerRenderCache() {
        Iterator r100 = CollectionsKt.listOf(new String[]{"", "", "", ""}).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        String r102 = (String) r100.next();
        ILiveEffectComposerManager r103 = getComposerManager();
        StringBuilder r104 = new StringBuilder("amgOnly_live_bg_");
        r101 = r101 + 1;
        r104.append(r101);
        r103.n(r104.toString(), r102);
        goto L4
    }

    public final void hideAigcHint() {
        MutableLiveData<Pair<Boolean, String>> r100 = this._aigcHintStatus;
        Boolean r101 = Boolean.FALSE;
        Pair<Boolean, String> r102 = r100.getValue();
        if (r102 == null) goto L6;
        String r103 = r102.getSecond();
        if (r103 == null) goto L6;
    L7:
        r100.setValue(new Pair(r101, r103));
        return;
    L6:
        r103 = "";
        goto L7
    }

    public final LiveData<Pair<Boolean, String>> getAigcHintStatus() {
        return this._aigcHintStatus;
    }

    public final LiveData<com.bytedance.android.live.effect.sticker.ui.aigc.b> getAigcTaskPanelListener() {
        return this._aigcTaskPanelListener;
    }

    public final LiveData<Pair<AigcTaskPanelStatus, Bundle>> getAigcTaskPanelStatus() {
        return this._aigcTaskPanelStatus;
    }

    public final LiveData<Boolean> getAigcTaskPanelVisible() {
        return this._aigcTaskPanelVisible;
    }

    public static final /* synthetic */ s access$getAigcTaskManager$p(StickerAigcViewModel r100) {
        return r100.getAigcTaskManager();
    }

    public static final /* synthetic */ LiveEffectScene access$getScene$p(StickerAigcViewModel r100) {
        return r100.scene;
    }

    public static final /* synthetic */ StickerDialogUIViewModel access$getStickerDialogUIViewModel$p(StickerAigcViewModel r100) {
        return r100.getStickerDialogUIViewModel();
    }

    public static final /* synthetic */ StickerRenderViewModel access$getStickerRenderViewModel$p(StickerAigcViewModel r100) {
        return r100.getStickerRenderViewModel();
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerAigcViewModel r100) {
        return r100.type;
    }

    public static final /* synthetic */ MutableLiveData access$get_aigcHintStatus$p(StickerAigcViewModel r100) {
        return r100._aigcHintStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_aigcTaskPanelStatus$p(StickerAigcViewModel r100) {
        return r100._aigcTaskPanelStatus;
    }

    private final void setImageListToAigcSticker(List<String> r100) {
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        String r103 = (String) r101.next();
        ILiveEffectComposerManager r104 = getComposerManager();
        StringBuilder r105 = new StringBuilder("amgOnly_live_bg_");
        r102 = r102 + 1;
        r105.append(r102);
        r104.n(r105.toString(), r103);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, java.lang.String] */
    public final void updateAigcTaskPanelStatus(Sticker r110) {
        if (r110 != null) goto L4;
    L48:
        this._aigcTaskPanelVisible.setValue(Boolean.FALSE);
        return;
    L4:
        if (r110.isAigcSticker() == false) goto L48;
        long r100 = r110.getId();
        Map r101 = (Map) ((LinkedHashMap) getAigcTaskManager().f(CollectionsKt.listOf(Long.valueOf(r100)))).get(Long.valueOf(r100));
        if (r101 != null) goto L9;
        r101 = MapsKt.emptyMap();
    L9:
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        String r103 = "";
        r102.element = "";
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.values().iterator();
        boolean r106 = false;
        boolean r107 = false;
        boolean r108 = false;
    L11:
        if (r105.hasNext() == false) goto L27;
        AigcBackgroundImageGenerateTask r109 = (AigcBackgroundImageGenerateTask) r105.next();
        if (r109.getStatus() == LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L14;
        if (r109.getStatus() != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L11;
        r103 = r109.getKeyWord();
        r107 = true;
        goto L11
    L14:
        r102.element = r109.getKeyWord();
        r104.clear();
        Iterator<ImageModel> r111 = r109.getImageList().iterator();
    L16:
        if (r111.hasNext() == false) goto L22;
        List<String> r112 = r111.next().getUrls();
        if (r112 == null) goto L16;
        String r113 = (String) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L16;
        r104.add(r113);
        goto L16
    L22:
        r108 = true;
        goto L11
    L27:
        if (this.scene != LiveEffectScene.Preview) goto L29;
        this._aigcTaskPanelVisible.setValue(Boolean.TRUE);
        if (r107 == false) goto L40;
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r114 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r115 = AigcTaskPanelStatus.Running;
        Bundle r116 = new Bundle();
        r116.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), r103);
        r116.putBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), false);
        Unit r117 = Unit.INSTANCE;
        r114.setValue(new Pair(r115, r116));
        return;
    L40:
        if (r108 == true) goto L42;
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r118 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r119 = AigcTaskPanelStatus.Ready;
        Bundle r120 = new Bundle();
        r120.putBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), false);
        Unit r121 = Unit.INSTANCE;
        r118.setValue(new Pair(r119, r120));
    L46:
        this._aigcTaskPanelListener.setValue(new b(this, r100, r110));
        return;
    L42:
        if (getAigcTaskManager().g(r110.getId()) == false) goto L44;
        setImageListToAigcSticker(getAigcTaskManager().e(r104));
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r122 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r123 = AigcTaskPanelStatus.Ready;
        Bundle r124 = new Bundle();
        r124.putBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), true);
        Unit r125 = Unit.INSTANCE;
        r122.setValue(new Pair(r123, r124));
        getAigcTaskManager().m(r110, (String) r102.element, this.scene.getPage());
        goto L46
    L44:
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r126 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r127 = AigcTaskPanelStatus.Running;
        Bundle r128 = new Bundle();
        r128.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), (String) r102.element);
        r128.putBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), true);
        Unit r129 = Unit.INSTANCE;
        r126.setValue(new Pair(r127, r128));
        getAigcTaskManager().d(r104, new a(this, r110, r102));
        goto L46
    L29:
        if ((!r104.isEmpty()) == true) goto L31;
        return;
    L31:
        if (((String) r102.element).length() <= 0) goto L33;
        r106 = true;
    L33:
        if (r106 == false) goto L66;
        setImageListToAigcSticker(getAigcTaskManager().e(r104));
        getAigcTaskManager().m(r110, (String) r102.element, this.scene.getPage());
        return;
    }

    public static final /* synthetic */ void access$setImageListToAigcSticker(StickerAigcViewModel r100, List r101) {
        r100.setImageListToAigcSticker(r101);
    }

    public StickerAigcViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
        this.aigcTaskManager$delegate = LazyKt.lazy(new StickerAigcViewModel$aigcTaskManager$2(this));
        this.composerManager$delegate = LazyKt.lazy(new StickerAigcViewModel$composerManager$2(this));
        this._aigcTaskPanelVisible = new MutableLiveData();
        this._aigcTaskPanelStatus = new MutableLiveData();
        this._aigcHintStatus = new MutableLiveData();
        this._aigcTaskPanelListener = new MutableLiveData();
    }

    private final void onCommitAigcTaskFinish(Sticker r100, String r101, List<String> r102) {
        StickerRenderViewModel r103 = getStickerRenderViewModel();
        if (r103 == null) goto L18;
        LiveData<Sticker> r104 = r103.getRenderStickerData();
        if (r104 == null) goto L19;
        Sticker r105 = r104.getValue();
        if (r105 != null) goto L9;
        return;
    L9:
        if (r105.getId() != r100.getId()) goto L21;
        setImageListToAigcSticker(r102);
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r106 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r107 = AigcTaskPanelStatus.Done;
        Bundle r108 = new Bundle();
        r108.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), r101);
        Unit r109 = Unit.INSTANCE;
        r106.setValue(new Pair(r107, r108));
        MutableLiveData<Pair<Boolean, String>> r110 = this._aigcHintStatus;
        Boolean r111 = Boolean.TRUE;
        if (r102.isEmpty() == false) goto L13;
        String r112 = s1.B(R.string.ttlive_effect_aigc_task_commit_fail_hint);
    L14:
        r110.setValue(new Pair(r111, r112));
        if ((!r102.isEmpty()) == false) goto L22;
        List<String> r113 = q.f68881a;
        String r114 = this.scene.getPage();
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "keyword");
        Intrinsics.checkNotNullParameter(r114, "eventPage");
        HashMap r115 = new HashMap();
        r115.put("sticker_id", String.valueOf(r100.getId()));
        r115.put("key_word", r101);
        q.e("livesdk_live_ai_sticker_generate_success", r115, r114);
        return;
    L22:
        return;
    L13:
        r112 = s1.B(R.string.ttlive_effect_aigc_task_commit_success_hint_part1) + r102.size() + s1.B(R.string.ttlive_effect_aigc_task_commit_success_hint_part2);
        goto L14
    L21:
        return;
    L19:
        return;
    }

    public static final /* synthetic */ void access$onCommitAigcTaskFinish(StickerAigcViewModel r100, Sticker r101, String r102, List r103) {
        r100.onCommitAigcTaskFinish(r101, r102, r103);
    }
}
