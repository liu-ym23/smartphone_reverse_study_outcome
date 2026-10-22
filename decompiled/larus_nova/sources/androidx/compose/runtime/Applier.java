package androidx.compose.runtime;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0015\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H&J\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J\b\u0010\u0018\u001a\u00020\u0007H&J3\u0010\u0019\u001a\u00020\u00072\u001f\u0010\u001a\u001a\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/Applier;", "N", "", "current", "getCurrent", "()Ljava/lang/Object;", "onBeginChanges", "", "onEndChanges", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "node", "(Ljava/lang/Object;)V", "up", "insertTopDown", "index", "", "instance", "(ILjava/lang/Object;)V", "insertBottomUp", "remove", "count", "move", "from", RemoteMessageConst.TO, "clear", e1.REPLY_ACTION_APPLY, "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "value", "reuse", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Applier<N> {

    /* JADX INFO: renamed from: androidx.compose.runtime.Applier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<N> {
        public static void $default$onBeginChanges(Applier r100) {
        }

        public static void $default$onEndChanges(Applier r100) {
        }

        public static void $default$reuse(Applier r100) {
            Object r101 = r100.getCurrent();
            if ((r101 instanceof ComposeNodeLifecycleCallback) == false) goto L5;
            ComposeNodeLifecycleCallback r102 = (ComposeNodeLifecycleCallback) r101;
        L6:
            if (r102 == null) goto L9;
            r102.onReuse();
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        public static /* synthetic */ void access$onBeginChanges$jd(Applier r100) {
            $default$onBeginChanges(r100);
        }

        public static /* synthetic */ void access$onEndChanges$jd(Applier r100) {
            $default$onEndChanges(r100);
        }

        public static /* synthetic */ void access$reuse$jd(Applier r100) {
            $default$reuse(r100);
        }

        public static void $default$apply(Applier r100, Function2 r101, Object r102) {
            r101.invoke(r100.getCurrent(), r102);
        }

        public static /* synthetic */ void access$apply$jd(Applier r100, Function2 r101, Object r102) {
            $default$apply(r100, r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <N> void onBeginChanges(Applier<N> r100) {
            CC.access$onBeginChanges$jd(r100);
        }

        public static <N> void onEndChanges(Applier<N> r100) {
            CC.access$onEndChanges$jd(r100);
        }

        public static <N> void reuse(Applier<N> r100) {
            CC.access$reuse$jd(r100);
        }

        public static <N> void apply(Applier<N> r100, Function2<? super N, Object, Unit> r101, Object r102) {
            CC.access$apply$jd(r100, r101, r102);
        }
    }

    void apply(Function2<? super N, Object, Unit> r100, Object r101);

    void clear();

    void down(N r100);

    N getCurrent();

    void insertBottomUp(int r100, N r101);

    void insertTopDown(int r100, N r101);

    void move(int r100, int r101, int r102);

    void onBeginChanges();

    void onEndChanges();

    void remove(int r100, int r101);

    void reuse();

    void up();
}
