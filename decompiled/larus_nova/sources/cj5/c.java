package cj5;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bitable.lynx.pro.d;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.export.j;
import com.larksuite.component.universe_design.dialog.UDDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import qe5.e;

/* JADX INFO: loaded from: classes18.dex */
public interface c extends j {

    public interface a {
        void a(JSONArray r100, ug5.a.b r101, ug5.a.c r102);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f23970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f23971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f23973d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23974e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f23975f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f23976g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f23977h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f23978i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f23979j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f23980k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f23981l;

        public b() {
        }
    }

    void B7(FragmentActivity r100, String r101);

    void C8(Context r100, int r101, String r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, com.bytedance.ee.bear.middleground_permission_export.model.a r108, String r110, boolean r111, boolean r112);

    @Override // com.bytedance.ee.bear.share.export.j
    DialogFragment E0(ShareParams r100);

    void Ee(th5.b r100);

    void F0(FragmentActivity r100, String r101, int r102, String r103, String r104, String r105);

    void G8(Context r100, String r101, int r102, int r103);

    void H9(i r100, SharePanelState r101, km5.a r102);

    View I7(FragmentActivity r100, int r101, String r102, String r103, String r104, FolderVersion r105, boolean r106, boolean r107, Fragment r108);

    DialogFragment N2(ShareParams r100, Bundle r101, com.bytedance.ee.bear.document.share.a.C3158a r102, ShareDocInfo r103);

    void O0(FragmentActivity r100, String r101, String r102, String r103, String r104, boolean r105, ArrayList<UserInfo> r106, ArrayList<UserInfo> r107);

    View S7(Context r100, ShareParams r101, boolean r102, boolean r103, boolean r104);

    View T8(Context r100, boolean r101, String r102);

    DialogFragment Xe(FragmentActivity r100, boolean r101, int r102);

    void ad(FragmentActivity r100, String r101, int r102, String r103, String r104, int r105, String r106, String r107, SecretLevel r108, SecretApprovalDefModel r110, Map<String, Serializable> r111, SecretLevel r112);

    void c5(Context r100, String r101, int r102, String r103, Fragment r104);

    DialogFragment fa(ShareParams r100);

    View g2(Context r100, ShareParams r101);

    void hb(Fragment r100, int r101, e.c r102, e.b r103, SecretApprovalInstanceModel r104, SecretApprovalDefModel r105, SecretLevel r106, SecretLevel r107);

    View i2(FragmentActivity r100, Fragment r101, int r102, String r103, String r104, String r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, boolean r112, ArrayList r113);

    DialogFragment id(ShareParams r100, Bundle r101);

    DialogFragment k6(FragmentActivity r100, String r101, int r102, DocMetaInfo r103, String r104, String r105, boolean r106, Fragment r107, boolean r108);

    void l5(FragmentActivity r100, int r101, e.c r102, e.b r103, SecretApprovalInstanceModel r104, SecretApprovalDefModel r105, SecretLevel r106, SecretLevel r107);

    void le(Context r100, int r101, String r102, String r103, boolean r104, boolean r105, String r106, DialogInterface.OnClickListener r107, DialogInterface.OnClickListener r108, Integer r110, String r111);

    View n6(Context r100, boolean r101);

    UDDialog nc(Context r100, String r101);

    void o6(FragmentActivity r100, String r101, int r102, String r103, String r104);

    DialogFragment r3(FragmentActivity r100, String r101, int r102, DocMetaInfo r103, String r104, String r105);

    void rb(Context r100, b r101, HashMap<String, Serializable> r102, Fragment r103);

    View s7(Context r100, ShareParams r101);

    void w4(Fragment r100, String r101, int r102, String r103, String r104, int r105, String r106, SecretLevel r107, SecretApprovalDefModel r108, Map r110, SecretLevel r111);

    void wb(Context r100, TransferApplyInfo r101, Fragment r102, boolean r103);

    void xe(FragmentActivity r100, Fragment r101, String r102, String r103, ArrayList r104, ArrayList r105, ArrayList r106, d r107);
}
