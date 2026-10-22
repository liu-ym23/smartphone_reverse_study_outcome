package com.android.contacts.widget;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PinnedHeaderListDemoActivity extends ListActivity {
    private static final String TAG = "PinnedHeaderListDemoActivity";
    private Handler mHandler;

    public static final class TestPinnedHeaderListAdapter extends PinnedHeaderListAdapter {
        private String[] mHeaders;
        private int mPinnedHeaderCount;

        static /* synthetic */ int access$002(TestPinnedHeaderListAdapter r0, int r1) {
            r0.mPinnedHeaderCount = r1;
            return r1;
        }

        public TestPinnedHeaderListAdapter(Context r1) {
            super(r1);
            setPinnedPartitionHeadersEnabled(true);
        }

        public void setHeaders(String[] r1) {
            this.mHeaders = r1;
        }

        @Override // com.android.common.widget.CompositeCursorAdapter
        protected View newHeaderView(Context r1, int r2, Cursor r3, ViewGroup r4) {
            return LayoutInflater.from(r1).inflate(R.layout.list_section, null);
        }

        @Override // com.android.common.widget.CompositeCursorAdapter
        protected void bindHeaderView(View r1, int r2, Cursor r3) {
            ((TextView) r1.findViewById(R.id.header_text)).setText(this.mHeaders[r2]);
        }

        @Override // com.android.common.widget.CompositeCursorAdapter
        protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
            return LayoutInflater.from(r1).inflate(android.R.layout.simple_list_item_1, null);
        }

        @Override // com.android.common.widget.CompositeCursorAdapter
        protected void bindView(View r1, int r2, Cursor r3, int r4) {
            ((TextView) r1.findViewById(android.R.id.text1)).setText(r3.getString(1));
        }

        @Override // com.android.contacts.widget.PinnedHeaderListAdapter, com.android.contacts.widget.PinnedHeaderListView.PinnedHeaderAdapter
        public View getPinnedHeaderView(int r3, View r4, ViewGroup r5) {
            View r6 = LayoutInflater.from(getContext()).inflate(R.layout.list_section, r5, false);
            r6.setFocusable(false);
            r6.setEnabled(false);
            bindHeaderView(r6, r3, null);
            return r6;
        }

        @Override // com.android.contacts.widget.PinnedHeaderListAdapter, com.android.contacts.widget.PinnedHeaderListView.PinnedHeaderAdapter
        public int getPinnedHeaderCount() {
            return this.mPinnedHeaderCount;
        }
    }

    public void com_android_contacts_widget_PinnedHeaderListDemoActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_widget_PinnedHeaderListDemoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public PinnedHeaderListDemoActivity() {
        this.mHandler = new Handler();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        UiUtils.setWindowColorStatusBar(this);
        setContentView(R.layout.pinned_header_list_demo);
        final TestPinnedHeaderListAdapter r11 = new TestPinnedHeaderListAdapter(this);
        Bundle r0 = getIntent().getExtras();
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "no extras in intent");
        finish();
        return;
    L6:
        int[] r2 = IntentUtils.getIntArray(r0, "counts");
        String[] r3 = IntentUtils.getStringArray(r0, "names");
        boolean[] r4 = IntentUtils.getBooleanArray(r0, "showIfEmpty");
        IntentUtils.getBooleanArray(r0, "headers");
        int[] r1 = IntentUtils.getIntArray(r0, "delays");
        if (r2 == null) goto L25;
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        if (r1 == null) goto L25;
        r11.setHeaders(r3);
        final int r5 = 0;
        int r6 = 0;
    L14:
        if (r6 >= r2.length) goto L20;
        boolean r7 = r4[r6];
        if (r3[r6] == null) goto L18;
        boolean r8 = true;
    L19:
        r11.addPartition(r7, r8);
        TestPinnedHeaderListAdapter.access$002(r11, r3.length);
        r6 = r6 + 1;
        goto L14
    L18:
        r8 = false;
        goto L19
    L20:
        setListAdapter(r11);
    L22:
        if (r5 >= r2.length) goto L24;
        final Cursor r9 = makeCursor(r3[r5], r2[r5]);
        this.mHandler.postDelayed(new AnonymousClass1(this, r11, r5, r9), r1[r5]);
        r5 = r5 + 1;
        goto L22
    L24:
        return;
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Missing required extras");
        finish();
    }

    private Cursor makeCursor(String r8, int r9) {
        MatrixCursor r7 = new MatrixCursor(new String[]{"_id", r8});
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        r7.addRow(new Object[]{Integer.valueOf(r1), r8 + "[" + r1 + "]"});
        r1 = r1 + 1;
        goto L3
    L5:
        return r7;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_widget_PinnedHeaderListDemoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PinnedHeaderListDemoActivity r1) {
        r1.com_android_contacts_widget_PinnedHeaderListDemoActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
