package com.stepos.widget.recipient;

import La.D;
import La.H;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.recipient.StepOSRecipientBaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJM\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001f\u001a\u00020\u001e2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J5\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000e0!j\b\u0012\u0004\u0012\u00020\u000e`\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000e0!j\b\u0012\u0004\u0012\u00020\u000e`\"¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001cH\u0007¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientItemClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/content/Context;", "context", "Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "recipientEdit", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "adapter", "<init>", "(Landroid/content/Context;Lcom/stepos/widget/recipient/StepOSRecipientEdit;Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "(Landroid/content/Context;Lcom/stepos/widget/recipient/StepOSRecipientEdit;)V", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "querySafe", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", "id", "LY8/t;", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "processMultipleAccount", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "groupId", "addGroupData", "(J)I", "appContext", "Landroid/content/Context;", "Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "Landroid/content/ContentResolver;", "resolver", "Landroid/content/ContentResolver;", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientItemClickListener implements AdapterView.OnItemClickListener {
    private static final int COLUMN_COUNT = 4;
    public static final Uri CONTENT_GROUP_URI;
    private static final String TAG = "RecipientItemClick";
    private final StepOSRecipientBaseAdapter adapter;
    private final Context appContext;
    private final StepOSRecipientEdit recipientEdit;
    private final ContentResolver resolver;

    static {
        Uri uri = Uri.parse("content://com.android.contacts/data/emails/group");
        kotlin.jvm.internal.p.h(uri, "parse(...)");
        CONTENT_GROUP_URI = uri;
    }

    public StepOSRecipientItemClickListener(Context context, StepOSRecipientEdit recipientEdit, StepOSRecipientBaseAdapter adapter) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(recipientEdit, "recipientEdit");
        kotlin.jvm.internal.p.i(adapter, "adapter");
        this.appContext = context;
        this.recipientEdit = recipientEdit;
        this.adapter = adapter;
        this.resolver = context.getContentResolver();
    }

    private final Cursor querySafe(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        try {
            return this.resolver.query(uri, projection, selection, selectionArgs, sortOrder);
        } catch (IllegalArgumentException e10) {
            Log.w(TAG, "query invalid: " + uri, e10);
            return null;
        } catch (SecurityException e11) {
            Log.w(TAG, "query denied: " + uri, e11);
            return null;
        } catch (Exception e12) {
            Log.w(TAG, "query failed: " + uri, e12);
            return null;
        }
    }

    public final int addGroupData(long groupId) {
        Log.d(TAG, "addGroupData " + groupId);
        Uri uriWithAppendedId = ContentUris.withAppendedId(CONTENT_GROUP_URI, groupId);
        kotlin.jvm.internal.p.h(uriWithAppendedId, "withAppendedId(...)");
        Cursor cursorQuerySafe = querySafe(uriWithAppendedId, StepOSRecipientBaseAdapter.PROJECTION, null, null, "sort_key");
        int i10 = 0;
        if (cursorQuerySafe == null) {
            return 0;
        }
        try {
            if (cursorQuerySafe.getCount() > 0) {
                cursorQuerySafe.moveToPosition(-1);
                int i11 = 0;
                while (cursorQuerySafe.moveToNext()) {
                    String string = cursorQuerySafe.getString(1);
                    String str = "";
                    if (string == null) {
                        string = "";
                    }
                    String string2 = cursorQuerySafe.getString(0);
                    if (string2 != null) {
                        str = string2;
                    }
                    if (this.recipientEdit.addRecipientInternal(string, str, false)) {
                        i11++;
                    }
                }
                i10 = i11;
            }
            if (i10 > 0) {
                this.recipientEdit.refreshLayout();
            }
            return i10;
        } finally {
            cursorQuerySafe.close();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String string;
        String string2;
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(view, "view");
        int partitionForPosition = this.adapter.getPartitionForPosition(position);
        if (partitionForPosition < 0) {
            return;
        }
        int cursorIndexForPosition = this.adapter.getCursorIndexForPosition(position);
        Cursor cursor = this.adapter.getCursor(partitionForPosition);
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(cursorIndexForPosition) || cursor.getColumnCount() < 4) {
            string = "";
            string2 = string;
        } else {
            string = cursor.getString(0);
            if (string == null) {
                string = "";
            }
            string2 = cursor.getString(1);
            if (string2 == null) {
                string2 = "";
            }
        }
        if (this.adapter.getInputType() != 2) {
            if (this.adapter.isGroupData(position)) {
                addGroupData(id);
                return;
            } else if (TextUtils.isEmpty(string2)) {
                this.recipientEdit.addRecipient(string);
                return;
            } else {
                this.recipientEdit.addRecipient(string2, string);
                return;
            }
        }
        if (this.adapter.isGroupData(position)) {
            addGroupData(id);
            return;
        }
        if (cursor.moveToPosition(cursorIndexForPosition)) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (cursor.getColumnCount() == 1) {
                Iterator<StepOSRecipientBaseAdapter.Recipient> it = StepOSRecipientBaseAdapter.Recipient.INSTANCE.dataToRecipientList(cursor.getBlob(0)).iterator();
                kotlin.jvm.internal.p.h(it, "iterator(...)");
                while (it.hasNext()) {
                    StepOSRecipientBaseAdapter.Recipient next = it.next();
                    kotlin.jvm.internal.p.h(next, "next(...)");
                    StepOSRecipientBaseAdapter.Recipient recipient = next;
                    if (TextUtils.isEmpty(recipient.getMDisplayName())) {
                        arrayList.add(recipient.getMAddress());
                    } else {
                        arrayList.add(recipient.getMAddress() + Const.STR_MART_SEMICOLON + recipient.getMDisplayName());
                    }
                }
            } else if (TextUtils.isEmpty(cursor.getString(0))) {
                String string3 = cursor.getString(1);
                arrayList.add(string3 != null ? string3 : "");
            } else {
                arrayList.add(cursor.getString(1) + Const.STR_MART_SEMICOLON + cursor.getString(0));
            }
            this.recipientEdit.addRecipient(processMultipleAccount(arrayList));
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    public final ArrayList<String> processMultipleAccount(ArrayList<String> list) {
        int i10;
        int i11;
        int i12;
        String strSubstring;
        StepOSRecipientItemClickListener stepOSRecipientItemClickListener = this;
        kotlin.jvm.internal.p.i(list, "list");
        int size = stepOSRecipientItemClickListener.adapter.getSize();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            String str = next;
            List listB1 = H.b1(str, new String[]{Const.STR_MART_SEMICOLON}, false, 0, 6, null);
            int i13 = 1;
            if (listB1.size() > 1) {
                String str2 = (String) listB1.get(1);
                int i14 = 0;
                String str3 = (String) listB1.get(0);
                String str4 = str;
                int i15 = 0;
                int i16 = 0;
                while (i15 < size) {
                    Cursor cursor = stepOSRecipientItemClickListener.adapter.getCursor(i15);
                    if (cursor == null) {
                        i12 = i13;
                        i11 = i14;
                        i10 = i15;
                    } else {
                        cursor.moveToPosition(-1);
                        while (cursor.moveToNext()) {
                            if (cursor.getColumnCount() == i13) {
                                Iterator<StepOSRecipientBaseAdapter.Recipient> it2 = StepOSRecipientBaseAdapter.Recipient.INSTANCE.dataToRecipientList(cursor.getBlob(i14)).iterator();
                                kotlin.jvm.internal.p.h(it2, "iterator(...)");
                                while (it2.hasNext()) {
                                    StepOSRecipientBaseAdapter.Recipient next2 = it2.next();
                                    kotlin.jvm.internal.p.h(next2, "next(...)");
                                    StepOSRecipientBaseAdapter.Recipient recipient = next2;
                                    if (D.L(recipient.getMDisplayName(), str2, true) && !D.L(recipient.getMAddress(), str3, true)) {
                                        i16++;
                                    }
                                }
                            } else {
                                ?? r02 = i13;
                                if (cursor.getColumnCount() > r02 && D.L(cursor.getString(0), str2, r02) && !D.L(cursor.getString(r02 == true ? 1 : 0), str3, r02)) {
                                    i16++;
                                }
                            }
                            if (i16 > 0) {
                                break;
                            }
                            i13 = 1;
                            i14 = 0;
                        }
                        int i17 = i16;
                        if (i17 > 0) {
                            i10 = i15;
                            i12 = 1;
                            int iT0 = H.t0(str3, '@', 0, false, 6, null) + 1;
                            int iT02 = H.t0(str3, '.', 0, false, 6, null);
                            String strSubstring2 = "";
                            if (iT0 > 0) {
                                strSubstring = str3.substring(iT0, str3.length() - 1);
                                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                            } else {
                                strSubstring = "";
                            }
                            if (iT0 > 0 && iT02 > iT0) {
                                strSubstring2 = str3.substring(iT0, iT02);
                                kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                            }
                            if (strSubstring2.length() > 0) {
                                i11 = 0;
                                if (!H.g0(str2, strSubstring, false, 2, null)) {
                                    str4 = str + ";(" + strSubstring2 + ")";
                                }
                            } else {
                                i11 = 0;
                            }
                        } else {
                            i10 = i15;
                            i11 = 0;
                            i12 = 1;
                        }
                        i16 = i17;
                    }
                    i15 = i10 + 1;
                    stepOSRecipientItemClickListener = this;
                    i14 = i11;
                    i13 = i12;
                }
                str = str4;
            }
            arrayList.add(str);
            stepOSRecipientItemClickListener = this;
        }
        return arrayList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StepOSRecipientItemClickListener(Context context, StepOSRecipientEdit recipientEdit) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(recipientEdit, "recipientEdit");
        StepOSRecipientBaseAdapter recipientAdapter = recipientEdit.getRecipientAdapter();
        if (recipientAdapter != null) {
            this(context, recipientEdit, recipientAdapter);
            return;
        }
        throw new IllegalStateException("StepOSRecipientEdit has no adapter; call setAdapter() first or pass StepOSRecipientBaseAdapter explicitly");
    }
}
