package ar8;

import android.os.Bundle;
import com.larus.search.api.model.SchemaSuffixMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16043a = 0;

    static {
    }

    public c() {
    }

    public static Bundle a(String r100, SchemaSuffixMap r101) {
        Intrinsics.checkNotNullParameter(r100, "jumpUrl");
        Bundle r102 = new Bundle();
        r102.putString("link_url", r100);
        r102.putString("hide_title_bar", "1");
        r102.putString("is_not_full_page", "1");
        r102.putString("is_show_progress_bar", "0");
        Map<String, String> r103 = r101.getMap();
        if (r103 == null) goto L7;
        boolean r104 = true;
        if ((!r103.isEmpty()) != true) goto L7;
    L8:
        if (r104 == false) goto L10;
        r102.putString("need_schema_premix", "1");
        r102.putSerializable("schema_suffix_map", r101);
    L10:
        r102.putString("is_show_center_progress_bar", "1");
        return r102;
    L7:
        r104 = false;
        goto L8
    }
}
