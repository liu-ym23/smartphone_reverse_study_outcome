package com.zyql.intenttaskmanager.sdk;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import f8.GuiTaskProgress;
import f8.ToolProgressNotification;
import f8.ToolResponse;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/os/Bundle;", "Lf8/a;", Const.INTENT_KEY_UMID, "(Landroid/os/Bundle;)Lf8/a;", "Lf8/b;", "f", "(Landroid/os/Bundle;)Lf8/b;", "Lf8/c;", "e", "(Landroid/os/Bundle;)Lf8/c;", "sdk_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class a {
    public static final GuiTaskProgress d(Bundle bundle) {
        Bitmap bitmap = (Bitmap) bundle.getParcelable("bitmap", Bitmap.class);
        String string = bundle.getString("taskId");
        String str = string == null ? "" : string;
        String string2 = bundle.getString("taskName");
        String str2 = string2 == null ? "" : string2;
        String string3 = bundle.getString("action");
        return new GuiTaskProgress(str, str2, string3 == null ? "" : string3, bundle.getString("bitmapId"), bitmap, bundle.getString("bitmapUrl"), Integer.valueOf(bundle.getInt("status", -1)), bundle.getString("message"), bundle);
    }

    public static final ToolResponse e(Bundle bundle) {
        String string = bundle.getString("toolCallId");
        if (string == null) {
            string = "";
        }
        return new ToolResponse(string, bundle.getBoolean("success", false), bundle.getString(SkillStoreKt.SKILL_DOC_TYPE_CONTENT), bundle.getString("extra"), bundle.getString("errorCode"), bundle.getString("errorMessage"));
    }

    public static final ToolProgressNotification f(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle bundle2 = bundle.getBundle("meta");
        if (bundle2 != null) {
            Set<String> setKeySet = bundle2.keySet();
            p.h(setKeySet, "keySet(...)");
            for (String str : setKeySet) {
                String string = bundle2.getString(str);
                if (string != null) {
                    linkedHashMap.put(str, string);
                }
            }
        }
        Double dValueOf = Double.valueOf(bundle.getDouble("progress"));
        if (!bundle.containsKey("progress")) {
            dValueOf = null;
        }
        return new ToolProgressNotification(dValueOf, bundle.containsKey("total") ? Double.valueOf(bundle.getDouble("total")) : null, bundle.getString("message"), linkedHashMap, bundle);
    }
}
