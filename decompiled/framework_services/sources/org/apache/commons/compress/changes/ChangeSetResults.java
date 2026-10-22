package org.apache.commons.compress.changes;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ChangeSetResults {
    private final List<String> addedFromChangeSet;
    private final List<String> addedFromStream;
    private final List<String> deleted;

    public ChangeSetResults() {
        this.addedFromChangeSet = new ArrayList();
        this.addedFromStream = new ArrayList();
        this.deleted = new ArrayList();
    }

    void deleted(String fileName) {
        this.deleted.add(fileName);
    }

    void addedFromStream(String fileName) {
        this.addedFromStream.add(fileName);
    }

    void addedFromChangeSet(String fileName) {
        this.addedFromChangeSet.add(fileName);
    }

    public List<String> getAddedFromChangeSet() {
        return this.addedFromChangeSet;
    }

    public List<String> getAddedFromStream() {
        return this.addedFromStream;
    }

    public List<String> getDeleted() {
        return this.deleted;
    }

    boolean hasBeenAdded(String filename) {
        if (this.addedFromChangeSet.contains(filename) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.addedFromStream.contains(filename) == true) goto L8;
        return false;
    }
}
