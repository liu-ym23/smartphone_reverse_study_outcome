package com.zyql.ai.selector.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zyql.ai.selector.PicturePreviewActivity;
import com.zyql.ai.selector.PictureSelectorPreviewWeChatStyleActivity;
import com.zyql.ai.selector.PictureVideoPlayActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes4.dex */
public class JumpUtils {
    public static void startPicturePreviewActivity(Context context, boolean z10, Bundle bundle, int i10) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, z10 ? PictureSelectorPreviewWeChatStyleActivity.class : PicturePreviewActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i10);
        } else {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public static void startPictureVideoPlayActivity(Context context, Bundle bundle, int i10) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PictureVideoPlayActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i10);
        } else {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }
}
