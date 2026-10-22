package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import v0.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        c.b aVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                aVar = new c.a(clipData, 3);
            } else {
                c.C0152c c0152c = new c.C0152c();
                c0152c.f13255a = clipData;
                c0152c.f13256b = 3;
                aVar = c0152c;
            }
            v0.e0.g(textView, aVar.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        c.b aVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            aVar = new c.a(clipData, 3);
        } else {
            c.C0152c c0152c = new c.C0152c();
            c0152c.f13255a = clipData;
            c0152c.f13256b = 3;
            aVar = c0152c;
        }
        v0.e0.g(view, aVar.build());
        return true;
    }
}
