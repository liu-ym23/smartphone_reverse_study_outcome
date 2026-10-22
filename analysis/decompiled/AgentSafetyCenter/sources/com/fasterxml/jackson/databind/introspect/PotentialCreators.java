package com.fasterxml.jackson.databind.introspect;

import b8.z;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PotentialCreators {
    private List<PotentialCreator> explicitDelegating;
    private List<PotentialCreator> implicitDelegatingConstructors;
    private List<PotentialCreator> implicitDelegatingFactories;
    public PotentialCreator propertiesBased;

    public void addExplicitDelegating(PotentialCreator potentialCreator) {
        if (this.explicitDelegating == null) {
            this.explicitDelegating = new ArrayList();
        }
        this.explicitDelegating.add(potentialCreator);
    }

    public List<PotentialCreator> getExplicitDelegating() {
        List<PotentialCreator> list = this.explicitDelegating;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<PotentialCreator> getImplicitDelegatingConstructors() {
        List<PotentialCreator> list = this.implicitDelegatingConstructors;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<PotentialCreator> getImplicitDelegatingFactories() {
        List<PotentialCreator> list = this.implicitDelegatingFactories;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public boolean hasDelegating() {
        List<PotentialCreator> list = this.explicitDelegating;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean hasPropertiesBased() {
        return this.propertiesBased != null;
    }

    public boolean hasPropertiesBasedOrDelegating() {
        if (this.propertiesBased != null) {
            return true;
        }
        List<PotentialCreator> list = this.explicitDelegating;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void setImplicitDelegating(List<PotentialCreator> list, List<PotentialCreator> list2) {
        this.implicitDelegatingConstructors = list;
        this.implicitDelegatingFactories = list2;
    }

    public void setPropertiesBased(MapperConfig<?> mapperConfig, PotentialCreator potentialCreator, String str) {
        PotentialCreator potentialCreator2 = this.propertiesBased;
        if (potentialCreator2 == null) {
            this.propertiesBased = potentialCreator.introspectParamNames(mapperConfig);
        } else {
            z.u("Conflicting property-based creators: already had %s creator %s, encountered another: %s", new Object[]{str, potentialCreator2.creator(), potentialCreator.creator()});
        }
    }
}
