package co5;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f24617a = 0;

    static {
    }

    public a() {
    }

    public static List a(JSONArray r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        JSONObject r104 = r100.optJSONObject(r103);
        SceneTemplateData.Scene r105 = new SceneTemplateData.Scene();
        r105.obj_token = r104.optString("obj_token");
        r105.obj_type = r104.optInt("obj_type");
        r105.name = r104.optString("name");
        r105.cover_download_url = r104.optString("cover_download_url");
        JSONObject r106 = r104.optJSONObject("thumbnail_extra");
        if (r106 != null) goto L10;
        SceneTemplateData.Extra r107 = new SceneTemplateData.Extra();
    L11:
        r105.thumbnail_extra = r107;
        r105.display_type = r104.optInt("display_type");
        r101.add(r105);
        r103 = r103 + 1;
        goto L6
    L10:
        SceneTemplateData.Extra r108 = new SceneTemplateData.Extra();
        r108.decrypt_key = r106.optString("decrypt_key");
        r108.thumbnail = r106.optString(DocCallbackImpl.KEY_THUMBNAIL);
        r108.type = r106.optInt("type");
        r107 = r108;
        goto L11
    L12:
        return r101;
    L4:
        return new ArrayList();
    }
}
