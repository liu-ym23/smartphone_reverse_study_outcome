package com.bytedance.android.livesdk.livecommerce.oldflash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u009d\u0001\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J¾\u0001\u0010&\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\f2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0002J\u001a\u0010)\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0002J\b\u0010*\u001a\u0004\u0018\u00010\u0002J\b\u0010+\u001a\u0004\u0018\u00010\u0002J\b\u0010,\u001a\u0004\u0018\u00010\u0002J\b\u0010-\u001a\u0004\u0018\u00010\u0002J\b\u0010.\u001a\u0004\u0018\u00010\u0002J\b\u0010/\u001a\u0004\u0018\u00010\u0002J\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\fJ\b\u00101\u001a\u0004\u0018\u00010\u0002J\b\u00102\u001a\u0004\u0018\u00010\u0002J\u000e\u00103\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0002J$\u00105\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u00106\u001a\u00020\u0002J\u0006\u00107\u001a\u00020\u0010J\u0006\u00108\u001a\u00020\u0012J\u0006\u00109\u001a\u00020\u0016J\u000e\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0012J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=0<J\u001b\u0010@\u001a\u00020\u00162\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020=¢\u0006\u0004\b@\u0010AR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010BR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010BR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010BR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010BR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010CR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010BR*\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010DR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010ER\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010FR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010BR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010BR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010GR\"\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010E\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010E\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010E\u001a\u0004\bW\u0010I\"\u0004\bX\u0010KR\"\u0010Y\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010E\u001a\u0004\bZ\u0010I\"\u0004\b[\u0010KR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR)\u0010i\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020d\u0018\u00010\r0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR!\u0010m\u001a\b\u0012\u0004\u0012\u00020j0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010f\u001a\u0004\bl\u0010hR#\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010n0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010f\u001a\u0004\bp\u0010hR!\u0010t\u001a\b\u0012\u0004\u0012\u00020d0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010f\u001a\u0004\bs\u0010hR1\u0010y\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010v0u0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010f\u001a\u0004\bx\u0010hR!\u0010}\u001a\b\u0012\u0004\u0012\u00020z0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010f\u001a\u0004\b|\u0010hR$\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010f\u001a\u0004\b\u007f\u0010hR*\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=0c8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010f\u001a\u0005\b\u0082\u0001\u0010h¨\u0006\u0086\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/LiveFlashViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseViewModel;", "", "broadcastId", "broadcastSecId", "roomId", "targetId", "categoryNames", "categoryIds", "", "clickTime", "shopId", "", "", "propertiesMulti", "targetName", "", "needBarCode", "", "barCodeState", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;", "flashController", "", "init", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;)V", "name", "cover", "stock", "price", "note", "propertiesForRequest", "lastPropertiesMulti", "barCodeInfo", "stockReduction", "depositOption", "privilegeCodeList", "deliveryDelayTime", "supplyDayReturnCode", "buildFlashPromotion", "names", "ids", "setCategory", "getRoomId", "getAnchorId", "getCategoryIds", "getCategoryId", "getCategoryNames", "getShopId", "getProperties", "getTargetId", "getTargetName", "setTargetName", "categoryId", "loadProperties", "getProductType", "isNeedBarCode", "getBarCodeState", "genBarCode", "position", "checkIsBarCodeItem", "Landroidx/lifecycle/LiveData;", "", "getAlertDialogMessage", "messages", "postAlertDialogMessage", "([Ljava/lang/String;)V", "Ljava/lang/String;", "J", "Ljava/util/Map;", "Z", "I", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;", "isCategoryChanged", "()Z", "setCategoryChanged", "(Z)V", "showErrorLine", "getShowErrorLine", "setShowErrorLine", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;", "eventHelper", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;", "getEventHelper", "()Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;", "setEventHelper", "(Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;)V", "hasLogShowSku", "getHasLogShowSku", "setHasLogShowSku", "canLogShowSku", "getCanLogShowSku", "setCanLogShowSku", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;", "flashHelper", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;", "getFlashHelper", "()Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;", "setFlashHelper", "(Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/b;", "flashItemList$delegate", "Lkotlin/Lazy;", "getFlashItemList", "()Landroidx/lifecycle/MutableLiveData;", "flashItemList", "Ljava/lang/Void;", "flashSuccessObserver$delegate", "getFlashSuccessObserver", "flashSuccessObserver", "Lxi2/o;", "flashFailObserver$delegate", "getFlashFailObserver", "flashFailObserver", "itemClickObserver$delegate", "getItemClickObserver", "itemClickObserver", "Lkotlin/Pair;", "Lxi2/v;", "propertyLoadObserver$delegate", "getPropertyLoadObserver", "propertyLoadObserver", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/a;", "barCodeClickObserver$delegate", "getBarCodeClickObserver", "barCodeClickObserver", "barCodeLoadObserver$delegate", "getBarCodeLoadObserver", "barCodeLoadObserver", "alertDialogMessages$delegate", "getAlertDialogMessages", "alertDialogMessages", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashViewModel extends ECBaseViewModel {
    private final Lazy alertDialogMessages$delegate;
    private final Lazy barCodeClickObserver$delegate;
    private final Lazy barCodeLoadObserver$delegate;
    private int barCodeState;
    private String broadcastId;
    private String broadcastSecId;
    private boolean canLogShowSku;
    private String categoryIds;
    private String categoryNames;
    private long clickTime;
    private q eventHelper;
    private FlashController flashController;
    private final Lazy flashFailObserver$delegate;
    private s flashHelper;
    private final Lazy flashItemList$delegate;
    private final Lazy flashSuccessObserver$delegate;
    private boolean hasLogShowSku;
    private boolean isCategoryChanged;
    private final Lazy itemClickObserver$delegate;
    private boolean needBarCode;
    private Map<String, ? extends List<String>> propertiesMulti;
    private final Lazy propertyLoadObserver$delegate;
    private String roomId;
    private String shopId;
    private boolean showErrorLine;
    private String targetId;
    private String targetName;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashViewModel f149559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f149560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f149561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f149562d;

        public a(LiveFlashViewModel r100, String[] r101, Map r102, int r103) {
            this.f149559a = r100;
            this.f149560b = r101;
            this.f149561c = r102;
            this.f149562d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            xi2.o r111 = (xi2.o) r110;
            if (r111 != null) goto L5;
        L23:
            this.f149559a.getFlashFailObserver().postValue(r111);
            return;
        L5:
            if (r111.statusCode != 0) goto L23;
            this.f149559a.getFlashSuccessObserver().postValue(null);
            q r112 = this.f149559a.getEventHelper();
            if (r112 == null) goto L9;
            new com.bytedance.android.livesdk.livecommerce.event.c0(r112.f149642a, r112.f149643b, r112.f149644c).k();
        L9:
            q r113 = this.f149559a.getEventHelper();
            if (r113 == null) goto L20;
            long r100 = LiveFlashViewModel.access$getClickTime$p(this.f149559a);
            String[] r101 = this.f149560b;
            if (r101 == null) goto L18;
            boolean r102 = false;
            if (r101.length != 0) goto L16;
            boolean r103 = true;
        L17:
            if (r103 == true) goto L18;
        L19:
            new com.bytedance.android.livesdk.livecommerce.event.w(r113.f149642a, r113.f149643b, System.currentTimeMillis() - r100, r113.f149644c, !r102).k();
            goto L20
        L16:
            r103 = false;
        L18:
            r102 = true;
        L20:
            FlashController r114 = LiveFlashViewModel.access$getFlashController$p(this.f149559a);
            String r104 = LiveFlashViewModel.access$getCategoryNames$p(this.f149559a);
            String r105 = LiveFlashViewModel.access$getCategoryIds$p(this.f149559a);
            Map<String, ? extends List<String>> r106 = this.f149561c;
            int r107 = this.f149562d;
            FlashController.b r115 = r114.f151530e;
            if (r115 == null) goto L25;
            r115.f151534d = r104;
            r115.f151535e = r105;
            r115.f151537g = r106;
            r115.f151532b = r107;
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashViewModel f149563a;

        public b(LiveFlashViewModel r100) {
            this.f149563a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f149563a.getFlashFailObserver().postValue(null);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashViewModel f149564a;

        public c(LiveFlashViewModel r100) {
            this.f149564a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            xi2.t r101 = (xi2.t) r100;
            String r102 = null;
            if (r101 != null) goto L5;
        L10:
            this.f149564a.getBarCodeLoadObserver().postValue(null);
            return;
        L5:
            if (r101.statusCode != 0) goto L10;
            MutableLiveData<String> r103 = this.f149564a.getBarCodeLoadObserver();
            List<String> r104 = r101.a();
            if (r104 == null) goto L9;
            r102 = (String) CollectionsKt.firstOrNull(r104);
        L9:
            r103.postValue(r102);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashViewModel f149565a;

        public d(LiveFlashViewModel r100) {
            this.f149565a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f149565a.getBarCodeLoadObserver().postValue(null);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashViewModel f149566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f149567b;

        public e(LiveFlashViewModel r100, String r101) {
            this.f149566a = r100;
            this.f149567b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            xi2.v r101 = (xi2.v) r100;
            if (r101 != null) goto L5;
        L7:
            this.f149566a.getPropertyLoadObserver().postValue(null);
            return;
        L5:
            if (r101.statusCode != 0) goto L7;
            this.f149566a.getPropertyLoadObserver().postValue(new Pair(this.f149567b, r101));
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashViewModel f149568a;

        public f(LiveFlashViewModel r100) {
            this.f149568a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f149568a.getPropertyLoadObserver().postValue(null);
        }
    }

    private final MutableLiveData<String[]> getAlertDialogMessages() {
        return (MutableLiveData) this.alertDialogMessages$delegate.getValue();
    }

    public final MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.a> getBarCodeClickObserver() {
        return (MutableLiveData) this.barCodeClickObserver$delegate.getValue();
    }

    public final MutableLiveData<String> getBarCodeLoadObserver() {
        return (MutableLiveData) this.barCodeLoadObserver$delegate.getValue();
    }

    public final MutableLiveData<xi2.o> getFlashFailObserver() {
        return (MutableLiveData) this.flashFailObserver$delegate.getValue();
    }

    public final MutableLiveData<List<com.bytedance.android.livesdk.livecommerce.oldflash.b>> getFlashItemList() {
        return (MutableLiveData) this.flashItemList$delegate.getValue();
    }

    public final MutableLiveData<Void> getFlashSuccessObserver() {
        return (MutableLiveData) this.flashSuccessObserver$delegate.getValue();
    }

    public final MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.b> getItemClickObserver() {
        return (MutableLiveData) this.itemClickObserver$delegate.getValue();
    }

    public final MutableLiveData<Pair<String, xi2.v>> getPropertyLoadObserver() {
        return (MutableLiveData) this.propertyLoadObserver$delegate.getValue();
    }

    public final void genBarCode() {
        String r100 = vi2.h.f555073a;
        nl2.b.b(vi2.h.e(null, null, si2.g.K, new vi2.g0()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this)));
    }

    public final String getCategoryId() {
        String r100 = this.categoryIds;
        if (r100 == null) goto L7;
        List r101 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        if (r101 == null) goto L7;
        return (String) CollectionsKt.lastOrNull(r101);
    L7:
        return null;
    }

    public final String getProductType() {
        String r100 = this.targetId;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return "buynow_all";
    L11:
        return "buynow_part";
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public LiveFlashViewModel() {
        this.broadcastId = "";
        this.broadcastSecId = "";
        this.roomId = "";
        this.categoryIds = "";
        this.categoryNames = "";
        this.shopId = "";
        this.targetId = "";
        this.targetName = "";
        this.canLogShowSku = true;
        this.flashItemList$delegate = LazyKt.lazy(LiveFlashViewModel$flashItemList$2.INSTANCE);
        this.flashSuccessObserver$delegate = LazyKt.lazy(LiveFlashViewModel$flashSuccessObserver$2.INSTANCE);
        this.flashFailObserver$delegate = LazyKt.lazy(LiveFlashViewModel$flashFailObserver$2.INSTANCE);
        this.itemClickObserver$delegate = LazyKt.lazy(LiveFlashViewModel$itemClickObserver$2.INSTANCE);
        this.propertyLoadObserver$delegate = LazyKt.lazy(LiveFlashViewModel$propertyLoadObserver$2.INSTANCE);
        this.barCodeClickObserver$delegate = LazyKt.lazy(LiveFlashViewModel$barCodeClickObserver$2.INSTANCE);
        this.barCodeLoadObserver$delegate = LazyKt.lazy(LiveFlashViewModel$barCodeLoadObserver$2.INSTANCE);
        this.alertDialogMessages$delegate = LazyKt.lazy(LiveFlashViewModel$alertDialogMessages$2.INSTANCE);
    }

    public final LiveData<String[]> getAlertDialogMessage() {
        return getAlertDialogMessages();
    }

    public final String getAnchorId() {
        return this.broadcastId;
    }

    public final int getBarCodeState() {
        return this.barCodeState;
    }

    public final boolean getCanLogShowSku() {
        return this.canLogShowSku;
    }

    public final String getCategoryIds() {
        return this.categoryIds;
    }

    public final String getCategoryNames() {
        return this.categoryNames;
    }

    public final q getEventHelper() {
        return this.eventHelper;
    }

    public final s getFlashHelper() {
        return this.flashHelper;
    }

    public final boolean getHasLogShowSku() {
        return this.hasLogShowSku;
    }

    public final Map<String, List<String>> getProperties() {
        return this.propertiesMulti;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowErrorLine() {
        return this.showErrorLine;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final boolean isCategoryChanged() {
        return this.isCategoryChanged;
    }

    public final boolean isNeedBarCode() {
        return this.needBarCode;
    }

    public static final /* synthetic */ String access$getCategoryIds$p(LiveFlashViewModel r100) {
        return r100.categoryIds;
    }

    public static final /* synthetic */ String access$getCategoryNames$p(LiveFlashViewModel r100) {
        return r100.categoryNames;
    }

    public static final /* synthetic */ long access$getClickTime$p(LiveFlashViewModel r100) {
        return r100.clickTime;
    }

    public static final /* synthetic */ FlashController access$getFlashController$p(LiveFlashViewModel r100) {
        FlashController r101 = r100.flashController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("flashController");
    L5:
        return r101;
    }

    public final boolean checkIsBarCodeItem(int r100) {
        List<com.bytedance.android.livesdk.livecommerce.oldflash.b> r101 = getFlashItemList().getValue();
        if (r101 == null) goto L16;
        int r102 = r101.size();
        if (r100 < 0) goto L19;
        if (r102 <= r100) goto L17;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r103 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) ListProtector.get(r101, r100);
        s r104 = this.flashHelper;
        if (r104 == null) goto L11;
        com.bytedance.android.livesdk.livecommerce.oldflash.a r105 = r104.f149654h;
    L13:
        if (Intrinsics.areEqual(r103, r105) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r105 = null;
        goto L13
    L17:
        return false;
    L19:
        return false;
    L16:
        return false;
    }

    public final void postAlertDialogMessage(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        getAlertDialogMessages().postValue(r100);
    }

    public final void setCanLogShowSku(boolean r100) {
        this.canLogShowSku = r100;
    }

    public final void setCategoryChanged(boolean r100) {
        this.isCategoryChanged = r100;
    }

    public final void setEventHelper(q r100) {
        this.eventHelper = r100;
    }

    public final void setFlashHelper(s r100) {
        this.flashHelper = r100;
    }

    public final void setHasLogShowSku(boolean r100) {
        this.hasLogShowSku = r100;
    }

    public final void setShowErrorLine(boolean r100) {
        this.showErrorLine = r100;
    }

    public final void setTargetName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.targetName = r100;
    }

    public static final /* synthetic */ void access$setCategoryIds$p(LiveFlashViewModel r100, String r101) {
        r100.categoryIds = r101;
    }

    public static final /* synthetic */ void access$setCategoryNames$p(LiveFlashViewModel r100, String r101) {
        r100.categoryNames = r101;
    }

    public static final /* synthetic */ void access$setClickTime$p(LiveFlashViewModel r100, long r101) {
        r100.clickTime = r101;
    }

    public static final /* synthetic */ void access$setFlashController$p(LiveFlashViewModel r100, FlashController r101) {
        r100.flashController = r101;
    }

    public final void setCategory(String r100, String r101) {
        if ((!Intrinsics.areEqual(r101, this.categoryIds)) == false) goto L5;
        this.isCategoryChanged = true;
    L5:
        this.categoryNames = r100;
        this.categoryIds = r101;
    }

    public final void loadProperties(String r100, String r101, String r102) {
        String r103 = vi2.h.f555073a;
        String r104 = vi2.h.d(si2.g.H);
        nl2.b.b(vi2.h.e(null, null, r104, new vi2.f0(r100, r101, r102, r104)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r100), new f(this)));
    }

    public final void init(String r100, String r101, String r102, String r103, String r104, String r105, long r106, String r110, Map<String, ? extends List<String>> r111, String r112, Boolean r113, Integer r114, FlashController r115) {
        Intrinsics.checkNotNullParameter(r115, "flashController");
        this.broadcastId = r100;
        this.broadcastSecId = r101;
        this.roomId = r102;
        this.targetId = r103;
        this.categoryIds = r105;
        this.categoryNames = r104;
        this.clickTime = r106;
        this.shopId = r110;
        this.propertiesMulti = r111;
        this.targetName = r112;
        this.eventHelper = new q(r100, r102, getProductType());
        int r107 = 0;
        if (r113 == null) goto L5;
        boolean r108 = r113.booleanValue();
    L6:
        this.needBarCode = r108;
        if (r114 == null) goto L9;
        r107 = r114.intValue();
    L9:
        this.barCodeState = r107;
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L13;
        if (r115 != null) goto L14;
        int r109 = FlashController.f151527f;
        r115 = ControllerCenter.c(null, null).f151425p;
        Objects.toString(r115);
    L14:
        this.flashController = r115;
        return;
    L13:
        int r116 = FlashController.f151527f;
        r115 = ControllerCenter.c(r102, null).f151425p;
        Objects.toString(r115);
        goto L14
    L5:
        r108 = false;
        goto L6
    }

    public final void buildFlashPromotion(String r210, String r211, String r212, int r213, int r214, String r310, Map<String, ? extends List<String>> r311, Map<String, ? extends List<String>> r312, List<String> r313, int r314, int r315, String r316, List<String> r317, long r318, String r410) {
        Intrinsics.checkNotNullParameter(r312, "lastPropertiesMulti");
        Intrinsics.checkNotNullParameter(r313, "barCodeInfo");
        if (r317 == null) goto L9;
        Object[] r100 = r317.toArray(new String[0]);
        if (r100 == null) goto L8;
        String[] r101 = (String[]) r100;
    L10:
        FlashController r102 = this.flashController;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("flashController");
    L13:
        String r110 = r102.D();
        String r103 = this.targetId;
        String r104 = String.valueOf(r213);
        String r105 = String.valueOf(r214);
        String r111 = this.categoryIds;
        String r112 = GsonProtectorUtils.toJson(new Gson(), r311);
        String r106 = (String) CollectionsKt.firstOrNull(r313);
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        String r113 = r106;
        String r114 = String.valueOf(r314);
        String r107 = vi2.h.f555073a;
        String r115 = vi2.h.d(si2.g.G);
        nl2.b.b(vi2.h.e(r210, r110, r115, new vi2.a0(r211, r103, r212, r104, r105, r310, r111, r210, r110, r112, r113, r114, r318, r410, r315, r316, r101, r115)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r101, r312, r314), new b(this)));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        r101 = null;
        goto L10
    }
}
