package com.android.server.om;

import android.content.om.OverlayIdentifier;

/* JADX INFO: loaded from: classes2.dex */
public final class DumpState {
    private String mField;
    private String mOverlayName;
    private String mPackageName;
    private int mUserId;
    private boolean mVerbose;

    public DumpState() {
        this.mUserId = -1;
    }

    public void setUserId(int userId) {
        this.mUserId = userId;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public void setOverlyIdentifier(String overlayIdentifier) {
        OverlayIdentifier overlay = OverlayIdentifier.fromString(overlayIdentifier);
        this.mPackageName = overlay.getPackageName();
        this.mOverlayName = overlay.getOverlayName();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getOverlayName() {
        return this.mOverlayName;
    }

    public void setField(String field) {
        this.mField = field;
    }

    public String getField() {
        return this.mField;
    }

    public void setVerbose(boolean verbose) {
        this.mVerbose = verbose;
    }

    public boolean isVerbose() {
        return this.mVerbose;
    }
}
