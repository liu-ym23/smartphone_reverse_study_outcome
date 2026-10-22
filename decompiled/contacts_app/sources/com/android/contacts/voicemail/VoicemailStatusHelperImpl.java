package com.android.contacts.voicemail;

import android.database.Cursor;
import android.net.Uri;
import com.android.contacts.R;
import com.android.contacts.util.UriUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class VoicemailStatusHelperImpl implements VoicemailStatusHelper {
    private static final int CONFIGURATION_STATE_INDEX = 1;
    private static final int DATA_CHANNEL_STATE_INDEX = 2;
    private static final int NOTIFICATION_CHANNEL_STATE_INDEX = 3;
    private static final int NUM_COLUMNS = 6;
    public static final String[] PROJECTION = null;
    private static final int SETTINGS_URI_INDEX = 4;
    private static final int SOURCE_PACKAGE_INDEX = 0;
    private static final int VOICEMAIL_ACCESS_URI_INDEX = 5;

    public static final enum Action extends Enum<Action> {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final Action CALL_VOICEMAIL = null;
        public static final Action CONFIGURE_VOICEMAIL = null;
        public static final Action NONE = null;
        private final int mMessageId;

        private static /* synthetic */ Action[] $values() {
            return new Action[]{NONE, CALL_VOICEMAIL, CONFIGURE_VOICEMAIL};
        }

        public static Action valueOf(String r1) {
            return (Action) Enum.valueOf(Action.class, r1);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        static {
            NONE = new Action("NONE", 0, -1);
            CALL_VOICEMAIL = new Action("CALL_VOICEMAIL", 1, R.string.voicemail_status_action_call_server);
            CONFIGURE_VOICEMAIL = new Action("CONFIGURE_VOICEMAIL", 2, R.string.common_settings);
            $VALUES = $values();
        }

        private Action(String r1, int r2, int r3) {
            super(r1, r2);
            this.mMessageId = r3;
        }

        public int getMessageId() {
            return this.mMessageId;
        }
    }

    private static class MessageStatusWithPriority {
        private final VoicemailStatusHelper.StatusMessage mMessage;
        private final int mPriority;

        static /* synthetic */ int access$000(MessageStatusWithPriority r0) {
            return r0.mPriority;
        }

        static /* synthetic */ VoicemailStatusHelper.StatusMessage access$100(MessageStatusWithPriority r0) {
            return r0.mMessage;
        }

        public MessageStatusWithPriority(VoicemailStatusHelper.StatusMessage r1, int r2) {
            this.mMessage = r1;
            this.mPriority = r2;
        }
    }

    private static final enum OverallState extends Enum<OverallState> {
        private static final /* synthetic */ OverallState[] $VALUES = null;
        public static final OverallState INVALID = null;
        public static final OverallState INVITE_FOR_CONFIGURATION = null;
        public static final OverallState MESSAGE_WAITING = null;
        public static final OverallState NOT_CONFIGURED = null;
        public static final OverallState NO_CONNECTION = null;
        public static final OverallState NO_DATA = null;
        public static final OverallState NO_DETAILED_NOTIFICATION = null;
        public static final OverallState NO_NOTIFICATIONS = null;
        public static final OverallState OK = null;
        private final Action mAction;
        private final int mCallDetailsMessageId;
        private final int mCallLogMessageId;
        private final int mPriority;

        private static /* synthetic */ OverallState[] $values() {
            return new OverallState[]{NO_CONNECTION, NO_DATA, MESSAGE_WAITING, NO_NOTIFICATIONS, INVITE_FOR_CONFIGURATION, NO_DETAILED_NOTIFICATION, NOT_CONFIGURED, OK, INVALID};
        }

        public static OverallState valueOf(String r1) {
            return (OverallState) Enum.valueOf(OverallState.class, r1);
        }

        public static OverallState[] values() {
            return (OverallState[]) $VALUES.clone();
        }

        static {
            NO_CONNECTION = new OverallState("NO_CONNECTION", 0, 0, Action.CALL_VOICEMAIL, R.string.voicemail_status_voicemail_not_available, R.string.voicemail_status_audio_not_available);
            NO_DATA = new OverallState("NO_DATA", 1, 1, Action.CALL_VOICEMAIL, R.string.voicemail_status_voicemail_not_available, R.string.voicemail_status_audio_not_available);
            MESSAGE_WAITING = new OverallState("MESSAGE_WAITING", 2, 2, Action.CALL_VOICEMAIL, R.string.voicemail_status_messages_waiting, R.string.voicemail_status_audio_not_available);
            NO_NOTIFICATIONS = new OverallState("NO_NOTIFICATIONS", 3, 3, Action.CALL_VOICEMAIL, R.string.voicemail_status_voicemail_not_available);
            INVITE_FOR_CONFIGURATION = new OverallState("INVITE_FOR_CONFIGURATION", 4, 4, Action.CONFIGURE_VOICEMAIL, R.string.voicemail_status_configure_voicemail);
            NO_DETAILED_NOTIFICATION = new OverallState("NO_DETAILED_NOTIFICATION", 5, 5, Action.NONE, -1);
            NOT_CONFIGURED = new OverallState("NOT_CONFIGURED", 6, 6, Action.NONE, -1);
            OK = new OverallState("OK", 7, 7, Action.NONE, -1);
            INVALID = new OverallState("INVALID", 8, 8, Action.NONE, -1);
            $VALUES = $values();
        }

        private OverallState(String r8, int r9, int r10, Action r11, int r12) {
            this(r8, r9, r10, r11, r12, -1);
        }

        private OverallState(String r1, int r2, int r3, Action r4, int r5, int r6) {
            super(r1, r2);
            this.mPriority = r3;
            this.mAction = r4;
            this.mCallLogMessageId = r5;
            this.mCallDetailsMessageId = r6;
        }

        public Action getAction() {
            return this.mAction;
        }

        public int getPriority() {
            return this.mPriority;
        }

        public int getCallLogMessageId() {
            return this.mCallLogMessageId;
        }

        public int getCallDetailsMessageId() {
            return this.mCallDetailsMessageId;
        }
    }

    public VoicemailStatusHelperImpl() {
    }

    static {
        PROJECTION = new String[]{"source_package", "configuration_state", "data_channel_state", "notification_channel_state", "settings_uri", "voicemail_access_uri"};
    }

    @Override // com.android.contacts.voicemail.VoicemailStatusHelper
    public List<VoicemailStatusHelper.StatusMessage> getStatusMessages(Cursor r3) {
        ArrayList r0 = new ArrayList();
        r3.moveToPosition(-1);
    L4:
        if (r3.moveToNext() == false) goto L9;
        MessageStatusWithPriority r1 = getMessageForStatusEntry(r3);
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return reorderMessages(r0);
    }

    @Override // com.android.contacts.voicemail.VoicemailStatusHelper
    public int getNumberActivityVoicemailSources(Cursor r3) {
        r3.moveToPosition(-1);
        int r0 = 0;
    L4:
        if (r3.moveToNext() == false) goto L8;
        if (isVoicemailSourceActive(r3) == false) goto L4;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0;
    }

    private boolean isVoicemailSourceActive(Cursor r2) {
        if (r2.getString(0) != null) goto L5;
        return false;
    L5:
        if (r2.getInt(1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private List<VoicemailStatusHelper.StatusMessage> reorderMessages(List<MessageStatusWithPriority> r2) {
        Collections.sort(r2, new AnonymousClass1(this));
        ArrayList r1 = new ArrayList();
        Iterator<MessageStatusWithPriority> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r1.add(MessageStatusWithPriority.access$100(r3.next()));
        goto L4
    L6:
        return r1;
    }

    private MessageStatusWithPriority getMessageForStatusEntry(Cursor r8) {
        String r2 = r8.getString(0);
        if (r2 != null) goto L5;
        return null;
    L5:
        OverallState r7 = getOverallState(r8.getInt(1), r8.getInt(2), r8.getInt(3));
        Action r1 = r7.getAction();
        if (r1 != Action.NONE) goto L9;
        return null;
    L9:
        if (r1 != Action.CALL_VOICEMAIL) goto L13;
        Uri r9 = UriUtils.parseUriOrNull(r8.getString(5));
    L11:
        Uri r6 = r9;
    L19:
        return new MessageStatusWithPriority(new VoicemailStatusHelper.StatusMessage(r2, r7.getCallLogMessageId(), r7.getCallDetailsMessageId(), r1.getMessageId(), r6), r7.getPriority());
    L13:
        if (r1 != Action.CONFIGURE_VOICEMAIL) goto L17;
        r9 = UriUtils.parseUriOrNull(r8.getString(4));
        if (r9 != null) goto L11;
        return null;
    L17:
        r6 = null;
        goto L19
    }

    private OverallState getOverallState(int r2, int r3, int r4) {
        if (r2 != 0) goto L24;
        if (r3 != 0) goto L14;
        if (r4 == 0) goto L7;
        if (r4 == 2) goto L10;
        if (r4 != 1) goto L31;
        return OverallState.NO_NOTIFICATIONS;
    L31:
        return OverallState.INVALID;
    L10:
        return OverallState.NO_DETAILED_NOTIFICATION;
    L7:
        return OverallState.OK;
    L14:
        if (r3 != 1) goto L31;
        if (r4 == 0) goto L17;
        if (r4 == 2) goto L20;
        if (r4 != 1) goto L31;
        return OverallState.NO_CONNECTION;
    L20:
        return OverallState.MESSAGE_WAITING;
    L17:
        return OverallState.NO_DATA;
    L24:
        if (r2 == 2) goto L26;
        if (r2 != 1) goto L31;
        return OverallState.NOT_CONFIGURED;
    L26:
        return OverallState.INVITE_FOR_CONFIGURATION;
    }
}
