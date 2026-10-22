package com.stepos.ailauncher.chat.wake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ShareWakeBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_SHARE_WAKE = "com.stepos.ailauncher.action.SHARE_WAKE";
    public static final String EXTRA_AUTO_SEND = "extra_auto_send";
    public static final String EXTRA_FILE_ID = "extra_file_id";
    public static final String EXTRA_SUGGEST_ITEMS = "suggest_items";
    public static final String EXTRA_SUGGEST_TITLE = "suggest_title";
    private static final String TAG = "ShareWakeBroadcastReceiver";

    public final String a(Intent intent) {
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        return charSequenceExtra != null ? charSequenceExtra.toString() : intent.getStringExtra("android.intent.extra.TEXT");
    }

    public final List<Uri> b(Intent intent) {
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
            if (uri != null) {
                arrayList.add(uri);
            }
        } else {
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                Uri uri2 = (Uri) it.next();
                if (uri2 != null) {
                    arrayList.add(uri2);
                }
            }
        }
        return arrayList;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra;
        if (context == null || intent == null) {
            return;
        }
        if (!ACTION_SHARE_WAKE.equals(intent.getAction())) {
            C4148a.b(TAG, "onReceive: ignore unexpected action=" + intent.getAction());
            return;
        }
        if (C5.b.a(context, this, "share_wake")) {
            String stringExtra = intent.getStringExtra(EXTRA_SUGGEST_TITLE);
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(EXTRA_SUGGEST_ITEMS);
            if (stringArrayListExtra == null && (stringArrayExtra = intent.getStringArrayExtra(EXTRA_SUGGEST_ITEMS)) != null && stringArrayExtra.length > 0) {
                stringArrayListExtra = new ArrayList<>(stringArrayExtra.length);
                for (String str : stringArrayExtra) {
                    if (str != null && !str.isEmpty()) {
                        stringArrayListExtra.add(str);
                    }
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(stringExtra);
            String strA = a(intent);
            List<Uri> listB = b(intent);
            String stringExtra2 = intent.getStringExtra(EXTRA_FILE_ID);
            boolean booleanExtra = intent.getBooleanExtra(EXTRA_AUTO_SEND, false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceive: hasSuggest=");
            sb2.append(!zIsEmpty);
            sb2.append(", text=");
            sb2.append(strA == null ? "null" : strA.length() + "chars");
            sb2.append(", uriCount=");
            sb2.append(listB.size());
            sb2.append(", fileId=");
            sb2.append(stringExtra2);
            sb2.append(", autoSend=");
            sb2.append(booleanExtra);
            C4148a.b(TAG, sb2.toString());
            if (zIsEmpty && TextUtils.isEmpty(strA) && listB.isEmpty()) {
                C4148a.b(TAG, "onReceive: empty payload, skip wake");
                return;
            }
            if (zIsEmpty) {
                if (!booleanExtra || TextUtils.isEmpty(strA) || !listB.isEmpty()) {
                    WakeService.INSTANCE.K1(context, strA, listB);
                    return;
                }
                C4148a.b(TAG, "onReceive: autoSend text -> sendTextToVisibleChatOrWake len=" + strA.length());
                WakeService.INSTANCE.j1(context, strA);
                return;
            }
            if (stringArrayListExtra == null) {
                stringArrayListExtra = new ArrayList<>();
            }
            ArrayList<String> arrayList = stringArrayListExtra;
            C4148a.b(TAG, "onReceive: wakeWithSuggestions items=" + arrayList.size() + " uriCount=" + listB.size() + " fileId=" + stringExtra2);
            WakeService.INSTANCE.W1(context, stringExtra, arrayList, strA, listB, stringExtra2);
        }
    }
}
