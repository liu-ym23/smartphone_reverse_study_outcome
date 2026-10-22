

package com.google.archivepatcher.applier;

import com.google.archivepatcher.shared.PatchConstants;
import com.google.archivepatcher.shared.Range;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DeltaDescriptor extends DeltaDescriptor {

  private final PatchConstants.DeltaFormat deltaFormat;

  private final Range deltaFriendlyOldFileRange;

  private final Range deltaFriendlyNewFileRange;

  private final long deltaLength;

  AutoValue_DeltaDescriptor(
      PatchConstants.DeltaFormat deltaFormat,
      Range deltaFriendlyOldFileRange,
      Range deltaFriendlyNewFileRange,
      long deltaLength) {
    if (deltaFormat == null) {
      throw new NullPointerException("Null deltaFormat");
    }
    this.deltaFormat = deltaFormat;
    if (deltaFriendlyOldFileRange == null) {
      throw new NullPointerException("Null deltaFriendlyOldFileRange");
    }
    this.deltaFriendlyOldFileRange = deltaFriendlyOldFileRange;
    if (deltaFriendlyNewFileRange == null) {
      throw new NullPointerException("Null deltaFriendlyNewFileRange");
    }
    this.deltaFriendlyNewFileRange = deltaFriendlyNewFileRange;
    this.deltaLength = deltaLength;
  }

  @Override
  public PatchConstants.DeltaFormat deltaFormat() {
    return deltaFormat;
  }

  @Override
  public Range deltaFriendlyOldFileRange() {
    return deltaFriendlyOldFileRange;
  }

  @Override
  public Range deltaFriendlyNewFileRange() {
    return deltaFriendlyNewFileRange;
  }

  @Override
  public long deltaLength() {
    return deltaLength;
  }

  @Override
  public String toString() {
    return "DeltaDescriptor{"
         + "deltaFormat=" + deltaFormat + ", "
         + "deltaFriendlyOldFileRange=" + deltaFriendlyOldFileRange + ", "
         + "deltaFriendlyNewFileRange=" + deltaFriendlyNewFileRange + ", "
         + "deltaLength=" + deltaLength
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DeltaDescriptor) {
      DeltaDescriptor that = (DeltaDescriptor) o;
      return (this.deltaFormat.equals(that.deltaFormat()))
           && (this.deltaFriendlyOldFileRange.equals(that.deltaFriendlyOldFileRange()))
           && (this.deltaFriendlyNewFileRange.equals(that.deltaFriendlyNewFileRange()))
           && (this.deltaLength == that.deltaLength());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= deltaFormat.hashCode();
    h$ *= 1000003;
    h$ ^= deltaFriendlyOldFileRange.hashCode();
    h$ *= 1000003;
    h$ ^= deltaFriendlyNewFileRange.hashCode();
    h$ *= 1000003;
    h$ ^= (int) ((deltaLength >>> 32) ^ deltaLength);
    return h$;
  }

}
