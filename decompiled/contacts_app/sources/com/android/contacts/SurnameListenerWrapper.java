package com.android.contacts;

import android.widget.ListAdapter;
import com.android.contacts.list.ContactTileAdapter;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SurnameMatcher;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class SurnameListenerWrapper implements OIndexScrollbar.SurnameListener {
    private HashMap<String, SurnameInfo> surnamePositionMap;

    private class SurnameInfo {
        int position;
        String sortKey;
        final /* synthetic */ SurnameListenerWrapper this$0;

        public SurnameInfo(SurnameListenerWrapper r1, int r2, String r3) {
            this.this$0 = r1;
            this.position = r2;
            this.sortKey = r3;
        }
    }

    public abstract ListAdapter getTargetListAdapter();

    public abstract void onSurnameClicked(int r1);

    public SurnameListenerWrapper() {
        this.surnamePositionMap = new HashMap();
    }

    static /* synthetic */ HashMap access$000(SurnameListenerWrapper r0) {
        return r0.surnamePositionMap;
    }

    @Override // com.obric.oui.indexscrollbar.OIndexScrollbar.SurnameListener
    public List<String> getMatchedSurnames(String r10) {
        this.surnamePositionMap.clear();
        ListAdapter r0 = getTargetListAdapter();
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.getCount();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L24;
        Object r4 = r0.getItem(r3);
        if ((r4 instanceof SamContact) == false) goto L16;
        SamContact r5 = (SamContact) r4;
        if (SurnameMatcher.getInstance().match(r10, r5.name, r5.sortkey, r5.section) == false) goto L22;
        String r6 = SurnameMatcher.getInstance().getSurname(r5.name);
        if (this.surnamePositionMap.keySet().contains(r6) == true) goto L22;
        this.surnamePositionMap.put(r6, new SurnameInfo(this, r3, r5.sortkey));
    L22:
        r3 = r3 + 1;
        goto L7
    L16:
        if ((r4 instanceof ContactTileAdapter.ContactEntry) == false) goto L22;
        ContactTileAdapter.ContactEntry r7 = (ContactTileAdapter.ContactEntry) r4;
        if (SurnameMatcher.getInstance().match(r10, r7.name, r7.sortkey, r7.section) == false) goto L22;
        String r8 = SurnameMatcher.getInstance().getSurname(r7.name);
        if (this.surnamePositionMap.keySet().contains(r8) == true) goto L22;
        this.surnamePositionMap.put(r8, new SurnameInfo(this, r3, r7.sortkey));
        goto L22
    L24:
        if (this.surnamePositionMap.isEmpty() == false) goto L33;
        String r11 = Locale.getDefault().getLanguage();
        if (Locale.ENGLISH.getLanguage().equals(r11) == true) goto L30;
        if ("ru".equals(r11) == true) goto L30;
    L32:
        ContactsApplication.showToast(R.string.toast_no_match_family_name, 0);
    L30:
        if (SurnameMatcher.getInstance().getSortOrder() != 1) goto L32;
        ContactsApplication.showToast(R.string.toast_no_match_given_name, 0);
    L33:
        ArrayList r12 = new ArrayList(this.surnamePositionMap.keySet());
        if (Locale.JAPAN.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L36;
        Collections.sort(r12, new AnonymousClass1(this));
    L37:
        return r12;
    L36:
        Collections.sort(r12, new AnonymousClass2(this));
        goto L37
    }

    @Override // com.obric.oui.indexscrollbar.OIndexScrollbar.SurnameListener
    public void onSurnameClicked(String r2) {
        SurnameInfo r3 = this.surnamePositionMap.get(r2);
        if (r3 == null) goto L6;
        onSurnameClicked(r3.position);
        return;
    }
}
