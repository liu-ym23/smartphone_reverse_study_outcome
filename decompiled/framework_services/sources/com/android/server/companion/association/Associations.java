package com.android.server.companion.association;

import android.companion.AssociationInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Associations {
    private List<AssociationInfo> mAssociations;
    private int mMaxId;
    private int mVersion;

    public Associations() {
        this.mVersion = 0;
        this.mAssociations = new ArrayList();
        this.mMaxId = 0;
    }

    public void setVersion(int version) {
        this.mVersion = version;
    }

    public void addAssociation(AssociationInfo association) {
        this.mAssociations.add(association);
    }

    public void setMaxId(int maxId) {
        this.mMaxId = maxId;
    }

    public void setAssociations(List<AssociationInfo> associations) {
        this.mAssociations = List.copyOf(associations);
    }

    public int getVersion() {
        return this.mVersion;
    }

    public int getMaxId() {
        return this.mMaxId;
    }

    public List<AssociationInfo> getAssociations() {
        return this.mAssociations;
    }
}
