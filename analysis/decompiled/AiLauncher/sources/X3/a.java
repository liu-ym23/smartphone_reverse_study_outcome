package X3;

import W3.EditTextNode;
import W3.MonitorRule;
import W3.SetTextTarget;
import W3.g;
import Z8.C1173v;
import Z8.C1174w;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n*\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\n*\u00020\u0005¢\u0006\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"LX3/a;", "", "<init>", "()V", "LW3/a;", "Landroid/os/Bundle;", Const.INTENT_KEY_PKGNAME, "(LW3/a;)Landroid/os/Bundle;", "c", "(Landroid/os/Bundle;)LW3/a;", "", Const.INTENT_KEY_UMID, "(Landroid/os/Bundle;)Ljava/util/List;", "LW3/c;", "", "e", "(Ljava/util/List;)Ljava/lang/String;", "LW3/h;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Landroid/os/Bundle;", "LW3/g;", "f", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6855a = new a();

    public final Bundle a(List<SetTextTarget> list) {
        p.i(list, "<this>");
        Bundle bundle = new Bundle();
        bundle.putInt("count", list.size());
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            SetTextTarget setTextTarget = (SetTextTarget) obj;
            bundle.putBundle("node_" + i10, f6855a.b(setTextTarget.getNode()));
            bundle.putString("text_" + i10, setTextTarget.getText());
            i10 = i11;
        }
        return bundle;
    }

    public final Bundle b(EditTextNode editTextNode) {
        p.i(editTextNode, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("viewId", editTextNode.getViewId());
        bundle.putString("text", editTextNode.getText());
        bundle.putString("hint", editTextNode.getHint());
        bundle.putInt("x", editTextNode.getX());
        bundle.putInt("y", editTextNode.getY());
        bundle.putInt("width", editTextNode.getWidth());
        bundle.putInt("height", editTextNode.getHeight());
        bundle.putBoolean("isFocused", editTextNode.getIsFocused());
        bundle.putBoolean("isEditable", editTextNode.getIsEditable());
        bundle.putInt("windowId", editTextNode.getWindowId());
        bundle.putInt("nodeHashCode", editTextNode.getNodeHashCode());
        bundle.putString("packageName", editTextNode.getPackageName());
        return bundle;
    }

    public final EditTextNode c(Bundle bundle) {
        p.i(bundle, "<this>");
        String string = bundle.getString("viewId", "");
        p.h(string, "getString(...)");
        String string2 = bundle.getString("text", "");
        p.h(string2, "getString(...)");
        String string3 = bundle.getString("hint", "");
        p.h(string3, "getString(...)");
        int i10 = bundle.getInt("x");
        int i11 = bundle.getInt("y");
        int i12 = bundle.getInt("width");
        int i13 = bundle.getInt("height");
        boolean z10 = bundle.getBoolean("isFocused");
        boolean z11 = bundle.getBoolean("isEditable");
        int i14 = bundle.getInt("windowId");
        int i15 = bundle.getInt("nodeHashCode");
        String string4 = bundle.getString("packageName", "");
        p.h(string4, "getString(...)");
        return new EditTextNode(string, string2, string3, i10, i11, i12, i13, z10, z11, i14, i15, string4);
    }

    public final List<EditTextNode> d(Bundle bundle) {
        p.i(bundle, "<this>");
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("nodes");
        if (parcelableArrayList == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(C1174w.x(parcelableArrayList, 10));
        for (Bundle bundle2 : parcelableArrayList) {
            a aVar = f6855a;
            p.f(bundle2);
            arrayList.add(aVar.c(bundle2));
        }
        return arrayList;
    }

    public final String e(List<MonitorRule> list) throws JSONException {
        p.i(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (MonitorRule monitorRule : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ruleName", monitorRule.getRuleName());
            jSONObject.put("packageName", monitorRule.getPackageName());
            jSONArray.put(jSONObject);
        }
        String string = jSONArray.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final List<g> f(Bundle bundle) {
        Object failure;
        p.i(bundle, "<this>");
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("results");
        if (parcelableArrayList == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(C1174w.x(parcelableArrayList, 10));
        for (Bundle bundle2 : parcelableArrayList) {
            int i10 = bundle2.getInt("code", -1);
            if (i10 == 0) {
                failure = g.b.f6658a;
            } else {
                String string = bundle2.getString("message");
                if (string == null) {
                    string = "unknown error";
                }
                failure = new g.Failure(i10, string);
            }
            arrayList.add(failure);
        }
        return arrayList;
    }
}
