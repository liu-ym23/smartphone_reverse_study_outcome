package com.android.server.companion.datatransfer.contextsync;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class CallMetadataSyncData {
    final List<CallControlRequest> mCallControlRequests;
    final List<CallCreateRequest> mCallCreateRequests;
    final List<CallFacilitator> mCallFacilitators;
    final Map<String, Call> mCalls;

    public static class Call {
        private static final String EXTRA_APP_ICON = "com.android.server.companion.datatransfer.contextsync.extra.APP_ICON";
        private static final String EXTRA_CALLER_ID = "com.android.server.companion.datatransfer.contextsync.extra.CALLER_ID";
        private static final String EXTRA_CONTROLS = "com.android.server.companion.datatransfer.contextsync.extra.CONTROLS";
        private static final String EXTRA_DIRECTION = "com.android.server.companion.datatransfer.contextsync.extra.DIRECTION";
        private static final String EXTRA_FACILITATOR_EXT_ID = "com.android.server.companion.datatransfer.contextsync.extra.FACILITATOR_EXT_ID";
        private static final String EXTRA_FACILITATOR_ID = "com.android.server.companion.datatransfer.contextsync.extra.FACILITATOR_ID";
        private static final String EXTRA_FACILITATOR_NAME = "com.android.server.companion.datatransfer.contextsync.extra.FACILITATOR_NAME";
        private static final String EXTRA_STATUS = "com.android.server.companion.datatransfer.contextsync.extra.STATUS";
        private byte[] mAppIcon;
        private String mCallerId;
        private final Set<Integer> mControls;
        private int mDirection;
        private CallFacilitator mFacilitator;
        private String mId;
        private int mStatus;

        public Call() {
            this.mControls = new HashSet();
        }

        public static Call fromBundle(Bundle bundle) {
            Call call = new Call();
            if (bundle == null) goto L5;
            call.setId(bundle.getString(CrossDeviceSyncController.EXTRA_CALL_ID));
            call.setCallerId(bundle.getString(EXTRA_CALLER_ID));
            call.setAppIcon(bundle.getByteArray(EXTRA_APP_ICON));
            String facilitatorName = bundle.getString(EXTRA_FACILITATOR_NAME);
            String facilitatorIdentifier = bundle.getString(EXTRA_FACILITATOR_ID);
            String facilitatorExtendedIdentifier = bundle.getString(EXTRA_FACILITATOR_EXT_ID);
            call.setFacilitator(new CallFacilitator(facilitatorName, facilitatorIdentifier, facilitatorExtendedIdentifier));
            call.setStatus(bundle.getInt(EXTRA_STATUS));
            call.setDirection(bundle.getInt(EXTRA_DIRECTION));
            call.setControls(new HashSet(bundle.getIntegerArrayList(EXTRA_CONTROLS)));
        L5:
            return call;
        }

        public Bundle writeToBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(CrossDeviceSyncController.EXTRA_CALL_ID, this.mId);
            bundle.putString(EXTRA_CALLER_ID, this.mCallerId);
            bundle.putByteArray(EXTRA_APP_ICON, this.mAppIcon);
            bundle.putString(EXTRA_FACILITATOR_NAME, this.mFacilitator.getName());
            bundle.putString(EXTRA_FACILITATOR_ID, this.mFacilitator.getIdentifier());
            bundle.putString(EXTRA_FACILITATOR_EXT_ID, this.mFacilitator.getExtendedIdentifier());
            bundle.putInt(EXTRA_STATUS, this.mStatus);
            bundle.putInt(EXTRA_DIRECTION, this.mDirection);
            bundle.putIntegerArrayList(EXTRA_CONTROLS, new ArrayList(this.mControls));
            return bundle;
        }

        void setId(String id) {
            this.mId = id;
        }

        void setCallerId(String callerId) {
            this.mCallerId = callerId;
        }

        void setAppIcon(byte[] appIcon) {
            this.mAppIcon = appIcon;
        }

        void setFacilitator(CallFacilitator facilitator) {
            this.mFacilitator = facilitator;
        }

        void setStatus(int status) {
            this.mStatus = status;
        }

        void setDirection(int direction) {
            this.mDirection = direction;
        }

        void addControl(int control) {
            this.mControls.add(Integer.valueOf(control));
        }

        void setControls(Set<Integer> controls) {
            this.mControls.clear();
            this.mControls.addAll(controls);
        }

        String getId() {
            return this.mId;
        }

        String getCallerId() {
            return this.mCallerId;
        }

        byte[] getAppIcon() {
            return this.mAppIcon;
        }

        CallFacilitator getFacilitator() {
            return this.mFacilitator;
        }

        int getStatus() {
            return this.mStatus;
        }

        int getDirection() {
            return this.mDirection;
        }

        Set<Integer> getControls() {
            return this.mControls;
        }

        boolean hasControl(int control) {
            return this.mControls.contains(Integer.valueOf(control));
        }

        public boolean equals(Object other) {
            if ((other instanceof Call) == true) goto L5;
            return false;
        L5:
            if (this.mId != null) goto L7;
            return false;
        L7:
            if (this.mId.equals(((Call) other).getId()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.mId);
        }
    }

    public static class CallControlRequest {
        private int mControl;
        private String mId;

        public CallControlRequest() {
        }

        public void setId(String id) {
            this.mId = id;
        }

        public void setControl(int control) {
            this.mControl = control;
        }

        public String getId() {
            return this.mId;
        }

        public int getControl() {
            return this.mControl;
        }
    }

    public static class CallCreateRequest {
        private String mAddress;
        private CallFacilitator mFacilitator;
        private String mId;

        public CallCreateRequest() {
        }

        public void setId(String id) {
            this.mId = id;
        }

        public void setAddress(String address) {
            this.mAddress = address;
        }

        public void setFacilitator(CallFacilitator facilitator) {
            this.mFacilitator = facilitator;
        }

        public String getId() {
            return this.mId;
        }

        public String getAddress() {
            return this.mAddress;
        }

        public CallFacilitator getFacilitator() {
            return this.mFacilitator;
        }
    }

    public static class CallFacilitator {
        private String mExtendedIdentifier;
        private String mIdentifier;
        private boolean mIsTel;
        private String mName;

        CallFacilitator() {
        }

        CallFacilitator(String name, String identifier, String extendedIdentifier) {
            this.mName = name;
            this.mIdentifier = identifier;
            this.mExtendedIdentifier = extendedIdentifier;
        }

        public String getName() {
            return this.mName;
        }

        public String getIdentifier() {
            return this.mIdentifier;
        }

        public String getExtendedIdentifier() {
            return this.mExtendedIdentifier;
        }

        public boolean isTel() {
            return this.mIsTel;
        }

        public void setName(String name) {
            this.mName = name;
        }

        public void setIdentifier(String identifier) {
            this.mIdentifier = identifier;
        }

        public void setExtendedIdentifier(String extendedIdentifier) {
            this.mExtendedIdentifier = extendedIdentifier;
        }

        public void setIsTel(boolean isTel) {
            this.mIsTel = isTel;
        }
    }

    CallMetadataSyncData() {
        this.mCalls = new HashMap();
        this.mCallCreateRequests = new ArrayList();
        this.mCallControlRequests = new ArrayList();
        this.mCallFacilitators = new ArrayList();
    }

    public void addCall(Call call) {
        this.mCalls.put(call.getId(), call);
    }

    public boolean hasCall(String id) {
        return this.mCalls.containsKey(id);
    }

    public Collection<Call> getCalls() {
        return this.mCalls.values();
    }

    public void addCallCreateRequest(CallCreateRequest request) {
        this.mCallCreateRequests.add(request);
    }

    public List<CallCreateRequest> getCallCreateRequests() {
        return this.mCallCreateRequests;
    }

    public void addCallControlRequest(CallControlRequest request) {
        this.mCallControlRequests.add(request);
    }

    public List<CallControlRequest> getCallControlRequests() {
        return this.mCallControlRequests;
    }

    public void addFacilitator(CallFacilitator facilitator) {
        this.mCallFacilitators.add(facilitator);
    }

    public List<CallFacilitator> getFacilitators() {
        return this.mCallFacilitators;
    }
}
