package com.android.contacts.calllog;

import android.content.res.Resources;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes.dex */
public class CallTypeHelper {
    private final CharSequence mAnsweredElsewhereName;
    private final CharSequence mIncomingName;
    private final CharSequence mMissedName;
    private final int mNewMissedColor;
    private final int mNewVoicemailColor;
    private final CharSequence mOutgoingName;
    private final CharSequence mVoicemailName;

    public CallTypeHelper(Resources r2) {
        this.mIncomingName = r2.getString(R.string.type_incoming);
        this.mOutgoingName = r2.getString(R.string.type_outgoing);
        this.mMissedName = r2.getString(R.string.type_missed);
        this.mVoicemailName = r2.getString(R.string.common_voice_mail);
        this.mAnsweredElsewhereName = r2.getString(R.string.type_answered_elsewhere);
        this.mNewMissedColor = r2.getColor(R.color.oui_functional_red_7);
        this.mNewVoicemailColor = r2.getColor(R.color.call_log_voicemail_highlight_color);
    }

    public CharSequence getCallTypeText(int r3) {
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L21;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L17;
        if (r3 != 7) goto L15;
        return this.mAnsweredElsewhereName;
    L15:
        throw new IllegalArgumentException("invalid call type: " + r3);
    L17:
        return this.mVoicemailName;
    L19:
        return this.mMissedName;
    L21:
        return this.mOutgoingName;
    L23:
        return this.mIncomingName;
    }

    public Integer getHighlightedColor(int r3) {
        if (r3 != 1) goto L5;
    L19:
        return null;
    L5:
        if (r3 == 2) goto L19;
        if (r3 == 3) goto L18;
        if (r3 == 4) goto L16;
        if (r3 == 7) goto L19;
        throw new IllegalArgumentException("invalid call type: " + r3);
    L16:
        return Integer.valueOf(this.mNewVoicemailColor);
    L18:
        return Integer.valueOf(this.mNewMissedColor);
    }
}
