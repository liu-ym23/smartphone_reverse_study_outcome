package aza;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.office.base.s;
import com.ss.android.lark.flow.feed.page.FlowHumanFeedItemsFragment;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kza.h;

/* JADX INFO: loaded from: classes34.dex */
public interface d extends IOfficeSDKCapacity {

    public static final class a {
        public static /* synthetic */ void a(d r110, Context r111, String r112, String r113, String r114, Integer r115, Integer r116, boolean r117, boolean r210, int r211) {
            if ((r211 & 16) == 0) goto L5;
            Integer r100 = null;
        L7:
            if ((r211 & 32) == 0) goto L9;
            Integer r101 = null;
        L11:
            if ((r211 & 64) == 0) goto L13;
            boolean r118 = false;
        L15:
            if ((r211 & 128) == 0) goto L17;
            boolean r119 = false;
        L18:
            r110.p7(r111, r112, r113, r114, r100, r101, r118, r119);
            return;
        L17:
            r119 = r210;
            goto L18
        L13:
            r118 = r117;
            goto L15
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    b E4();

    void E7(Context r100, String r101);

    void G9(uh9.b.a r100);

    fza.a J4();

    void J5(hza.b r100);

    dza.b P();

    FlowHumanFeedItemsFragment Q8();

    void R6(hza.b r100);

    void W7();

    h X9();

    nza.b Z1();

    bza.a ab();

    void g9(FragmentActivity r100, boolean r101);

    cza.a getAvatarService();

    Object ma(Continuation<? super Result<pza.a>> r100);

    void p7(Context r100, String r101, String r102, String r103, Integer r104, Integer r105, boolean r106, boolean r107);

    void q4(s r100);

    void s8(uh9.b.a r100);
}
